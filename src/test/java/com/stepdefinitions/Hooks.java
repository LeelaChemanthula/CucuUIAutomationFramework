package com.stepdefinitions;

import com.utilities.ExtentTestReportUtility;
import com.utilities.LoadEnvirnmentProperties;
import com.utilities.TestReportingUtility;
import io.cucumber.java.*;

public class Hooks {

	public static Hooks obj = new Hooks();

	private String currentFeature;
	private String previousFeature;

	private TestReportingUtility testReportingUtility;
	LoadEnvirnmentProperties envProps = LoadEnvirnmentProperties.getInstance();

	public Hooks(){
		testReportingUtility = ExtentTestReportUtility.getInstance();
		System.out.println("Hooks Const:" + testReportingUtility);
		previousFeature = testReportingUtility.previousFeature;
	}
	
	public static Hooks getInstance(){
		if(obj == null){
			obj = new Hooks();
		}
		return obj;
	}
	

	@Before
	public void beforeScenario(Scenario scenario){

		String projectLoc = envProps.getEnvProperty("projectLoc");
		currentFeature = scenario.getId();
		currentFeature = currentFeature.replace("file:///", "");
		currentFeature = currentFeature.replace(projectLoc, "");
		int indexOfLastSlash = currentFeature.lastIndexOf("/");
		currentFeature = currentFeature.substring(indexOfLastSlash+1, currentFeature.length());
		currentFeature = currentFeature.substring(0, currentFeature.indexOf(".feature:"));
		
		System.out.println("Current Feature Name: " + currentFeature);

		if(!previousFeature.equalsIgnoreCase(currentFeature)){
			testReportingUtility.createTestReportFeature(currentFeature);
			previousFeature = currentFeature;
		}
		testReportingUtility.createTestReportScenario(scenario);
	}

	@BeforeStep
	public void beforeStep(Scenario scenario){
	}
	
	@AfterStep
	public void afterStep(Scenario scenario){

		testReportingUtility.logStepStatus(scenario);
	}

	@After
	public void afterScenario(Scenario scenario){

		testReportingUtility.generateTestReport();
	}
}
