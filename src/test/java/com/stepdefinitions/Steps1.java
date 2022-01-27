package com.stepdefinitions;

import com.constants.Consts;
import com.customexceptions.PageClassNotFoundException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@RunWith(Cucumber.class)
public class Steps1 extends Steps {

	public static final Steps1 obj = new Steps1();

	public Steps1(){
		//super();
	}
	
    @When("^(user is on page) \"([^\"]*)\"$")
    public void onPage(String stepName, String pageName) {

		try{
				getPageObject(pageName);
				testReportUtility.setReportData(stepName + " " + pageName, "", "");

		}catch (PageClassNotFoundException e){

				actualData = setExceptionMsg(e.getMessage());
				testReportUtility.setReportData(stepName +" " + pageName, pageName, actualData);
				assertTrue(actualData.equalsIgnoreCase(pageName));
		}
    }


    @When("^(user fills the form data)$")
    public void fillsForm(String stepName, DataTable dataTable) {
    	String xpathKey;
    	String data;
    	ArrayList<String> dataList = new ArrayList<>();
    	try {
			for (int count = 1; count < dataTable.height(); count++) {
				List<String> dt = dataTable.row(count);
				xpathKey = dt.get(0);
				data = dt.get(1);
				getWebElement(xpathKey).sendKeys(data);
				dataList.add(data);
			}
			testReportUtility.setReportData(stepName, dataList.toString(), "");
		}catch (Exception e){

			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, "", actualData);
			assertEquals(actualData, dataList.toString());
		}
    }
 
    @When("^(user enters data)$")
    public void entersData(String stepName, DataTable dataTable) {
    	String xpathKey;
    	try {
			xpathKey = dataTable.row(1).get(0);
			expectedData = dataTable.row(1).get(1);
			getWebElement(xpathKey).sendKeys(expectedData);
			actualData = getWebElement(xpathKey).getText();
			testReportUtility.setReportData(stepName, expectedData, actualData);
		}catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, expectedData, actualData);
			assertEquals(actualData, expectedData);
		}
    }
    
    @When("^(user enters data in the textbox) \"([^\"]*)\" as \"([^\"]*)\"$")
    public void entersDataInTextbox(String stepName, String xpathKey, String expectedData) {
		try {
			getWebElement(xpathKey).sendKeys(expectedData);
			actualData = getWebElement(xpathKey).getText();
			testReportUtility.setReportData(stepName + " " + xpathKey, expectedData, actualData);

		}catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName + " " + xpathKey, expectedData, actualData);
			assertEquals(actualData, expectedData);
		}
    }
    
    @Given("^(user launches the application) \"([^\"]*)\"$")
    public void launchesApplication(String stepName, String applicationName){
		try{
			String appToLoad = utilMethods.getApplicationUrl(applicationName);
			actualData = loadApplication(appToLoad);
			testReportUtility.setReportData(stepName + " "+ applicationName, "complete", actualData);
			assertTrue(actualData.equalsIgnoreCase("complete"));

    	}catch (Exception e) {
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName +" " + applicationName, "complete", actualData);
			assertTrue(actualData.equalsIgnoreCase("complete"));

		}catch (AssertionError ae){
    		actualData = ae.toString();
			testReportUtility.setReportData(stepName + " " + applicationName, "complete", actualData);
			assertTrue(actualData.equalsIgnoreCase("complete"));
		}
    }

    @Then("^(user waits for page to load)$")
    public void userWaitsForPage(String stepName){
    	waitForPageToLoad();
		testReportUtility.setReportData(stepName, "", "");
    }

    
    @When("^(user clears data in the textbox) \"([^\"]*)\"$")
    public void clearsDataInTextbox(String stepName, String xpathKey) {
		try {
			getWebElement(xpathKey).clear();
			actualData = getWebElement(xpathKey).getText().trim();
			testReportUtility.setReportData(stepName, "", "");
		}catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, "", actualData);
			assertEquals(actualData, "");
		}
    }
    
    
    @When("^(user clicks the web element) \"([^\"]*)\"$")
    public void clicksWebElement(String stepName, String xpathKey) {
		try {
			getWebElement(xpathKey).click();
			testReportUtility.setReportData(stepName + " " + xpathKey, "", "");
		}catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, "", actualData);
			assertEquals(actualData,"");
		}
    }
    
    @When("^(user clicks the drop down) \"([^\"]*)\"$")
    public void clicksDropDown(String stepName, String xpathKey) {
    	try {
			getWebElement(xpathKey).click();
			testReportUtility.setReportData(stepName + " " + xpathKey, "", "");

		}catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, "", actualData);
			assertEquals(actualData, "");
		}
    }
    
    @When("^(user selects the drop down option) \"([^\"]*)\"$")
    public void selectTheOption(String stepName, String xpathKey){
		try {
			getWebElement(xpathKey).click();
			testReportUtility.setReportData(stepName + " \"" + xpathKey + "\"", "", "");
		}catch(Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName + "\"" + xpathKey + "\"", "", actualData);
			assertEquals(actualData, "");
		}
    }

    
    @Then("^(user closes the browser)$")
    public void closesBrowser(String stepName) {
		testReportUtility.setReportData(stepName, "", "");
    	driver.quit();
    }

    
    @Then("^(user validates element) \"([^\"]*)\" (is displayed as) \"([^\"]*)\"$")
    public void validateElementDisplayed(String stepName1, String xpathKey, String stepName2, String expectedData){

		try {
				expectedData = utilMethods.getConstsVariableVaue(expectedData);
				actualData = getWebElement(xpathKey).getText().trim();
				testReportUtility.setReportData(stepName1 + " " + xpathKey + " " + stepName2 + " "+ expectedData, expectedData, actualData);
				assertTrue(actualData.contains(expectedData.trim()));
		}
		catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName1 + " " + xpathKey + " " + stepName2 + " "+ expectedData, expectedData, actualData);
			assertTrue(actualData.contains(expectedData));
		}
		catch (AssertionError e){
			actualData = e.toString();
			testReportUtility.setReportData(stepName1 + " " + xpathKey + " " + stepName2 + " "+ expectedData,  expectedData, actualData);
			assertTrue(actualData.equalsIgnoreCase(expectedData));
		}
    }


    @When("^(user clicks the button) \"([^\"]*)\"$")
    public void clicksButton(String stepName, String xpathKey) {
    	try {
			getWebElement(xpathKey).click();
			testReportUtility.setReportData(stepName + " " + xpathKey, "", "");
		}catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName + " " + xpathKey, "", actualData);
			assertTrue(actualData.equalsIgnoreCase(""));
		}
    }
    
    @Then("^(user validates FaceBook Page title)$")
    public void validateFaceBookPageTitle(String stepName){

    	String xpathKey = "fbTitle";
    	try {
			actualData = getElementText(xpathKey);
			testReportUtility.setReportData(stepName, Consts.fbPageTitle, actualData);
			assertEquals(actualData, expectedData);
		}
    	catch(Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, Consts.fbPageTitle, actualData);
			assertTrue(actualData.contains(Consts.fbPageTitle));
		}
    	catch (AssertionError e){
			testReportUtility.setReportData(stepName, Consts.fbPageTitle, actualData);
			assertTrue(actualData.contains(Consts.fbPageTitle));
		}
    }


	@Then("^(user validates FB Create account message)$")
	public void validateFBAppointmentMsg(String stepName){

		String xpathKey = "fbCreateAcctMsg";
		try {
			actualData = getElementText(xpathKey);
			testReportUtility.setReportData(stepName, Consts.fbCreateAnAcctMsg, actualData);
			assertTrue(actualData.contains(Consts.fbCreateAnAcctMsg));
		}
		catch(Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, Consts.fbCreateAnAcctMsg, actualData);
			assertTrue(actualData.contains(Consts.fbCreateAnAcctMsg));

		}catch (AssertionError ae){
			testReportUtility.setReportData(stepName, Consts.fbCreateAnAcctMsg, actualData);
			assertTrue(actualData.contains(Consts.fbCreateAnAcctMsg));
		}
	}

	public String setExceptionMsg(String exceptionMsg){

    	if(exceptionMsg.contains("Session")) {
			int sessionInfoInd = exceptionMsg.indexOf("(Session");
			exceptionMsg = exceptionMsg.substring(0, sessionInfoInd);
		}
    	return exceptionMsg;
	}


	@When("^(user takes the appointment by) \"([^\"]*)\"$")
	public void takesAppointment(String stepName, String xpathKey){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String availableDoctorAreaXpath = "TakeAnAppointmentArea";

		try {
			Actions actions = new Actions(driver);
			WebElement availableDocEle = getWebElement(availableDoctorAreaXpath);
			actions.moveToElement(availableDocEle).perform();
			WebElement element = getWebElement(xpathKey);
            js.executeScript("arguments[0].style.border='1.5px solid blue'", element);
			actions.moveToElement(element).click().perform();
			testReportUtility.setReportData(stepName + " \"" + xpathKey + "\"", "", "");
		}catch(Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName + " \"" + xpathKey + "\"", "", actualData);
			assertEquals(actualData, "");
		}
	}


	@When("^(user selects a date in appointment calendar)")
	public void selectACalendarDate(String stepName, DataTable dataTable){

		String dateFormat;
		String noOfDays;
		String date;
		String dateSelected = "";
		String day;
		//String year;
		String timeSelected;

		try {

			List<String> dt = dataTable.row(1);
			dateFormat = dt.get(0);
			noOfDays = dt.get(1);
			date = utilMethods.generateDate(dateFormat,noOfDays);

			String monthToSelect = date.split(",")[0].trim();
			day = date.split(",")[1].trim();
			//year = date.split(",")[2];



			testReportUtility.setReportData(stepName, dateSelected, dateSelected);
		}
		catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, dateSelected, actualData);
			assertEquals(actualData, expectedData);
		}
	}


	private String generateDate(String dateFormat, String noOfdays) {

		SimpleDateFormat sdf;
		String newDate;

		//Generate Current System date
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		//Add / Subtract no of days
		int intNoOfdays = convertStringToInt(noOfdays);
		System.out.println("No of Days:" + intNoOfdays);
		calendar.add(Calendar.DAY_OF_MONTH, intNoOfdays);
		sdf = new SimpleDateFormat(dateFormat);
		newDate = sdf.format(calendar.getTime());
		System.out.println("System Generated Date: " + newDate);
		return newDate;
	}

	private int convertStringToInt(String strValue){
		if(strValue.length()==0)
			return 0;
		return Integer.parseInt(strValue);
	}


	@Then("^(user moves to new tab) \"([^\"]*)\"$")
	public void moveToNewTab(String stepName, String tabName) {
		try {
			Set<String> winHandlesSet = driver.getWindowHandles();
			List<String> winHandlesList = new ArrayList<>(winHandlesSet);
			String newTab = winHandlesList.get(winHandlesList.size() - 1);
			driver.switchTo().window(newTab);
			waitForPageToLoad();
			expectedData = tabName;
			actualData = driver.getTitle();
			testReportUtility.setReportData(stepName, tabName, actualData);
			if(tabName.equalsIgnoreCase(actualData))
				System.out.println("Moved to the correct tab : " + actualData);
			assertEquals(actualData, expectedData);
		} catch (Exception e) {
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, expectedData, actualData);
			assertEquals(actualData, expectedData);
		}
	}

	@Then("^(user closes the current tab) \"([^\"]*)\"$")
	public void closeCurrentTab(String stepName, String tabName) {
		try {
			Set<String> winHandlesSet = driver.getWindowHandles();
			List<String> winHandlesList = new ArrayList<>(winHandlesSet);
			String newTab = winHandlesList.get(winHandlesList.size() - 1);
			driver.switchTo().window(newTab);
			//waitForPageToLoad();
			expectedData = tabName;
			actualData = driver.getTitle();
			testReportUtility.setReportData(stepName, expectedData, actualData);
			assertEquals(actualData, expectedData);
			driver.close();
		} catch (Exception e) {
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, expectedData, actualData);
			assertEquals(actualData, expectedData);
		}
	}

	@When("^(user clears the form data)$")
	public void clearsForm(String stepName, DataTable dataTable){
		String xpathKey;
		try {
			for (int count = 1; count < dataTable.height(); count++) {
				List<String> dt = dataTable.row(count);
				xpathKey = dt.get(0);
				getWebElement(xpathKey).clear();
			}
			testReportUtility.setReportData(stepName, "", "");
		}catch (Exception e){
			actualData = setExceptionMsg(e.toString());
			testReportUtility.setReportData(stepName, "", actualData);
			//assertEquals(actualData, dataList.toString());
		}
	}

	private String getConstsVariableVaue(String varName){
		Object object;
		String value;
		try {
			Class constsClass = Class.forName("com.constants.Consts");
			final Field field = constsClass.getDeclaredField(varName);
			field.setAccessible(true);
			object = constsClass.newInstance();
			value = (String) field.get(object);
			return value;
		}
		catch (Exception e){
			return varName;
		}
    }

    //Image comparision is yet to be implemented
	@Then("^(user validates Google Page Image)$")
	public void validateGooglePageTitle(String stepName){

		String xpathKey = "googleTitle";
		try {

			testReportUtility.setReportData(stepName, Consts.fbPageTitle, actualData);
			assertEquals(actualData, expectedData);
		}
		catch(Exception e){

			testReportUtility.setReportData(stepName, Consts.fbPageTitle, actualData);
			assertTrue(actualData.contains(Consts.fbPageTitle));
		}
		catch (AssertionError e){
			testReportUtility.setReportData(stepName, Consts.fbPageTitle, actualData);
			assertTrue(actualData.contains(Consts.fbPageTitle));
		}
	}
}

