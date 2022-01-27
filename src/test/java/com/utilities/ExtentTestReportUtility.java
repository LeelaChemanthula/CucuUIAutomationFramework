package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.Consts;
import com.environmentprops.EnvironmentProps;
import io.cucumber.java.Scenario;

//https://www.extentreports.com/docs/versions/4/java/index.html

public class ExtentTestReportUtility extends TestReportingUtility{

	private ExtentReports extentReports;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentTestFeature;
	private ExtentTest extentTestScenario;
	private String extentReportfileName = "";

	public static ExtentTestReportUtility obj;

	private String stepDesc = "";
	private LoadEnvirnmentProperties envProps = LoadEnvirnmentProperties.getInstance();
	private String operatingSys = "";
	private UtilMethods utilMethods = UtilMethods.getInstance();

	private ExtentTestReportUtility(){
		driver = null;
	}
	
	public void createTestReportFeature(String featureName){
		this.previousFeature = featureName;
		initializeTestReport(featureName);
		extentTestFeature = extentReports.createTest(featureName);
	}
	
	public void createTestReportScenario(Scenario scenario){
		extentTestScenario = extentTestFeature.createNode(Consts.scenario + ": "+ scenario.getName());
	}
	
	public void generateTestReport(){
		extentReports.flush();
	}
	
	public void logStepStatus(Scenario scenario){
		String stepDesc = setStepDesc();
		String stepStatus = scenario.getStatus().toString();
		System.out.println("Step Status: " + scenario.getStatus());

		if(scenario.isFailed()) {
			extentTestScenario.log(Status.FAIL, stepDesc);
			driver.quit();
		}
		else
			extentTestScenario.log(Status.PASS, stepDesc);
	}
	
	public void setReportData(String stepName, String expectedData, String actualData){
		testReportDataHashMap.put(Consts.step, stepName);
		testReportDataHashMap.put(Consts.expected, expectedData);
		testReportDataHashMap.put(Consts.actual, actualData);
	}

	private String setStepDesc(){

		String expectedData = testReportDataHashMap.get(Consts.expected);
		String actualdata = testReportDataHashMap.get(Consts.actual);
		String stepName = testReportDataHashMap.get(Consts.step);

		if(expectedData.length()==0 && actualdata.length()==0) {
			stepDesc = "<b>" + "Step: " + "</b>" + stepName;
			return stepDesc;
		}

		if(expectedData.length()> 0 && actualdata.length() > 0) {
			stepDesc = "<b>" + "Step: " + "</b>" + stepName + "<br><b>Expected: " + "</b>" + expectedData + "<br>" + "<b>" + "Actual: " + "</b>" + actualdata;
			return stepDesc;
		}

		if(expectedData.length() > 0 && actualdata.length()==0) {
			stepDesc = "<b>" + "Step: " + "</b>" + stepName + "<br><b>Expected: " + "</b>" + expectedData;
			return stepDesc;
		}

		if(expectedData.length()==0 && actualdata.length() > 0) {
			stepDesc = "<b>" + "Step: " + "</b>" + stepName + "<br><b>Actual: " + "</b>" + actualdata;
			return stepDesc;
		}
		return stepDesc;
	}

	public static ExtentTestReportUtility getInstance(){
		if(obj == null){
			obj = new ExtentTestReportUtility();
		}
		return obj;
	}

	public void initializeTestReport(String testReportFileName){
		createHTMLExtentReporter(testReportFileName);
		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Test Environment", EnvironmentProps.testEnvironment);
		extentReports.setSystemInfo("Browser:",EnvironmentProps.browser);
		extentReports.setSystemInfo("OS:",operatingSys);
		extentReports.attachReporter(htmlReporter);
	}

	private void createHTMLExtentReporter(String testReportFileName){
		extentReportfileName = utilMethods.getCurrentDateTestReportsFolder() + "/" +
								testReportFileName + "_" +
								utilMethods.getCurrentTimestamp() +
								EnvironmentProps.extentReportFileExtension;

		htmlReporter = new ExtentHtmlReporter(extentReportfileName);
		operatingSys = System.getProperty("os.name");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(testReportFileName + " Extent Reports");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(testReportFileName  + " Automation Test Report");

	}
}
