package com.pageobjects;


public class GooglePage extends BasePage {

	private static GooglePage obj;
	
	private GooglePage(){
		//System.out.println("Constructor called GooglePage " + obj);
		super();
		page.put("googleTitle", "//div[text()='Sign in with Google']");
		page.put("searchBox", "//input[@name='q']");
		page.put("gmailLink","//a[text()='Gmail']");
	}
	
	public static GooglePage getInstance()
	{
		if(obj == null){
			obj = new GooglePage();
		}
		System.out.println("Obj created GooglePage " + obj);
		return obj;
	}

}
