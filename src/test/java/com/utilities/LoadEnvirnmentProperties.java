package com.utilities;

import com.customexceptions.EnvironmentPropertyNotFoundException;
import com.environmentprops.EnvironmentProps;

import java.util.HashMap;

public class LoadEnvirnmentProperties {
	
	private static LoadEnvirnmentProperties obj;
	
	//Project and Environment Vars
	public HashMap<String, String> propertiesMap = new HashMap<String, String>();

	private LoadEnvirnmentProperties(){
		propertiesMap.put("testEnvironment",EnvironmentProps.testEnvironment);
		propertiesMap.put("browser", EnvironmentProps.browser);

		String projectLoc = System.getProperty("user.dir");
		projectLoc = projectLoc.replace("\\","/");
		propertiesMap.put("projectLoc", projectLoc);

		propertiesMap.put("chromeDriverPath", projectLoc + EnvironmentProps.chromeDriverPath);
		propertiesMap.put("firefoxDriverPath", projectLoc + EnvironmentProps.fireFoxDriverPath);
		propertiesMap.put("ieDriverPath", projectLoc + EnvironmentProps.ieDriverPath);

		propertiesMap.put("testReportsLoc", projectLoc + "/testreports/extent-reports/");

		propertiesMap.put("devFBAppUrl",EnvironmentProps.devFBAppUrl);
		propertiesMap.put("qaFBAppUrl",EnvironmentProps.qaFBAppUrl);
		propertiesMap.put("uatFBAppUrl",EnvironmentProps.uatFBAppUrl);
		propertiesMap.put("devGoogleAppUrl",EnvironmentProps.devGoogleAppUrl);
		propertiesMap.put("qaGoogleAppUrl", EnvironmentProps.qaGoogleAppUrl);
		propertiesMap.put("uatGoogleAppUrl",EnvironmentProps.uatGoogleAppUrl);

		propertiesMap.put("maxWaitTime", EnvironmentProps.maxWaitTime);
		propertiesMap.put("waitInterval", EnvironmentProps.waitInterval);

		propertiesMap.put("extentReportFileExtension", EnvironmentProps.extentReportFileExtension);
	}
	
	public static LoadEnvirnmentProperties getInstance(){
		if(obj == null){
			obj = new LoadEnvirnmentProperties();
		}
		System.out.println("Obj created ApplicationProps " + obj);
		return obj;
	}

	public String getEnvProperty(String property) throws EnvironmentPropertyNotFoundException {
		System.out.print("Property : " + property);
		if(propertiesMap.containsKey(property))
			return propertiesMap.get(property);
		else
			throw new EnvironmentPropertyNotFoundException("'"+property+"'" + " Not found");
	}

}
