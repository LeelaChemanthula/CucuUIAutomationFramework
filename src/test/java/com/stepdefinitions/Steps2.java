package com.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@RunWith(Cucumber.class)
public class Steps2 extends Steps {

	public static final Steps2 obj = new Steps2();

	public Steps2(){
		super();
	}


	@Then("^(Step2 class test statement)")
	public void launchesApplication(String stepName){
		try{
			actualData = "complete";
			testReportUtility.setReportData(stepName,"complete",actualData);
			assertTrue(actualData.equalsIgnoreCase("complete"));

		}catch (Exception e) {
			testReportUtility.setReportData(stepName, "complete", actualData);
			assertTrue(actualData.equalsIgnoreCase("complete"));

		}catch (AssertionError ae){
			actualData = ae.toString();
			testReportUtility.setReportData(stepName, "complete", actualData);
			assertTrue(actualData.equalsIgnoreCase("complete"));
		}
	}


	@When("^(user enters my data)$")
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

}

