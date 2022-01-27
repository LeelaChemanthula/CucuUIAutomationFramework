package com.environmentprops;

public class EnvironmentProps {

	// Environments Properties
	public static String testEnvironment = "dev";
	public static String browser = "chrome";

	public static String maxWaitTime = "8000";
	public static String waitInterval = "1000";

	// Application URLs
	public static String devFBAppUrl = "https://www.facebook.com/";
	public static String qaFBAppUrl = "";
	public static String uatFBAppUrl = "";
	public static String devGoogleAppUrl = "https://www.google.com/";
	public static String qaGoogleAppUrl = "";
	public static String uatGoogleAppUrl = "";

	//TestAutomationReport file name and file extension
	public static String extentReportFileExtension = ".html";
	public static String extentReportOverallReportsFileName = "AutomationReport.html";

	public static String chromeDriverPath = "/webdrivers/chromedriver.exe";
	public static String fireFoxDriverPath = "/webdrivers/geckodriver.exe";
	public static String ieDriverPath = "/webdrivers/chromedriver.exe";
}
