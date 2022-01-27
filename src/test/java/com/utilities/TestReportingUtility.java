package com.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TestReportingUtility {

	public String previousFeature = "";
	public WebDriver driver;
	public HashMap<String, String> testReportDataHashMap = new HashMap<String, String>();

	public TestReportingUtility(){
	}

	public void initializeTestReport(String testReportFileName){}

	public void createTestReportFeature(String featureName){}

	public void createTestReportScenario(Scenario scenario){}

	public void logStepStatus(Scenario scenario){}

	public void generateTestReport(){}

	public void setReportData(String stepName, String expectedData, String actualData){}
}