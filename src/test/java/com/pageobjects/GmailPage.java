package com.pageobjects;


public class GmailPage extends BasePage {

	private static GmailPage obj;

	private GmailPage(){
		//System.out.println("Constructor called GmailPage " + obj);
		super();
		page.put("signIn","(//a)[4]");
		page.put("email","//input[@id='identifierId']");
		page.put("next","//span[text()='Next']");
		page.put("password","//input[@name='password']");
	}
	
	public static GmailPage getInstance()
	{
		if(obj == null) {
			obj = new GmailPage();
		}
		System.out.println("Obj created GooglePage " + obj);
		return obj;
	}

}
