package com.stepdefinitions;

import com.customexceptions.EnvironmentPropertyNotFoundException;
import com.customexceptions.PageClassNotFoundException;
import com.pageobjects.BasePage;
import com.pageobjects.DriverObjectFactory;
import com.pageobjects.PageObjectFactory;
import com.utilities.ExtentTestReportUtility;
import com.utilities.LoadEnvirnmentProperties;
import com.utilities.TestReportingUtility;
import com.utilities.UtilMethods;
import org.openqa.selenium.*;

public class Steps {

    public static final Steps obj = new Steps();

    public BasePage page;

    public WebDriver driver;
    private String applicationLoadStatus;

    public LoadEnvirnmentProperties envProps;
    public UtilMethods utilMethods;
    public PageObjectFactory pageFactory;
    public TestReportingUtility testReportUtility;
    public DriverObjectFactory driverObjectFactory;

    //Expected and Actual data vars for test data in Extent reports
    public String expectedData ="";
    public String actualData = "";

    public Steps(){
        envProps = LoadEnvirnmentProperties.getInstance();
        testReportUtility = ExtentTestReportUtility.getInstance();
        utilMethods = UtilMethods.getInstance();
        pageFactory = PageObjectFactory.getInstance();
        driverObjectFactory = DriverObjectFactory.getInstance();
    }

    public static Steps getInstance(){
        return obj;
    }

    public BasePage getPageObject(String pageName) throws PageClassNotFoundException{
        page = pageFactory.getPageObj(pageName);
        return page;
    }

    public String waitForPageToLoad() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        long maxWaitTime = utilMethods.convertStringToLong(envProps.getEnvProperty("maxWaitTime"));
        long waitInterval = utilMethods.convertStringToLong(envProps.getEnvProperty("waitInterval"));;

        while (maxWaitTime > 0) {
            try {
                Thread.sleep(waitInterval);
                maxWaitTime = maxWaitTime - waitInterval;
                applicationLoadStatus = (String) js.executeScript("return document.readyState;", "");
                // Check if the document load status is complete, if yes, break the loop
                if (applicationLoadStatus.equalsIgnoreCase("complete"))
                    break;
            } catch (Exception e) {
                System.out.println("waitForPageToLoad exception: " + e.toString());
            }
        }
        System.out.println("Remaining Time : " + maxWaitTime);
        return applicationLoadStatus;
    }

    public String loadApplication(String applName) throws EnvironmentPropertyNotFoundException {

        driver = driverObjectFactory.getDriverObject();
        testReportUtility.driver = driver;
        driver.get(applName);
        applicationLoadStatus = waitForPageToLoad();
        return applicationLoadStatus;
    }

    public WebElement getWebElement(String xpathKey) throws NoSuchElementException {
        String xpathValue = page.getXpath(xpathKey);
        WebElement element;
        System.out.println("getWebElement: xpathValue: " + xpathValue);
        if (xpathValue.startsWith("//") || (xpathValue.startsWith("(//") && xpathValue.endsWith("]")))
            element = driver.findElement(By.xpath(xpathValue));
        else
            element = driver.findElement(By.cssSelector(xpathValue));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='1.5px solid blue'", element);
        return element;
    }

    public WebElement getWebElementWithXpathValue(String xpathValue) throws NoSuchElementException{
        WebElement element;

        if (xpathValue.startsWith("//") || (xpathValue.startsWith("(//") && xpathValue.endsWith("]")))
            element = driver.findElement(By.xpath(xpathValue));
        else
            element = driver.findElement(By.cssSelector(xpathValue));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='1.5px solid blue'", element);
        return element;
    }

    public String getElementText(String xpathKey) throws NoSuchElementException {
        return getWebElement(xpathKey).getText();
    }

    public String setExceptionMsg(String exceptionMsg){

        if(exceptionMsg.contains("Session")) {
            int sessionInfoInd = exceptionMsg.indexOf("(Session");
            exceptionMsg = exceptionMsg.substring(0, sessionInfoInd);
        }
        return exceptionMsg;
    }
}
