package com.pageobjects;

import com.utilities.LoadEnvirnmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverObjectFactory {

    private static DriverObjectFactory obj;

    LoadEnvirnmentProperties envProps;
    String brower = "";
    WebDriver driver = null;

    public DriverObjectFactory(){
        envProps = LoadEnvirnmentProperties.getInstance();
        this.brower = envProps.getEnvProperty("browser");
    }

    public static DriverObjectFactory getInstance(){
        if(obj == null){
            obj = new DriverObjectFactory();
        }
        return obj;
    }

    public WebDriver getDriverObject() throws RuntimeException {
        brower = envProps.getEnvProperty("browser");

        switch (brower) {
            case "chrome":  System.setProperty("webdriver.chrome.driver", envProps.getEnvProperty("chromeDriverPath"));
                            System.out.println("Chrome driver path: " + envProps.getEnvProperty("chromeDriverPath"));
                            driver = new ChromeDriver();
                            break;

            case "firefox": System.setProperty("webdriver.gecko.driver", envProps.getEnvProperty("fireFoxDriverPath"));
                            driver = new FirefoxDriver();
                            break;

            case "iexplore": System.setProperty("webdriver.ie.driver", envProps.getEnvProperty("ieDriverPath"));
                             driver = new InternetExplorerDriver();
                             break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }
}
