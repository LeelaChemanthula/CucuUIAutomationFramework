package com.pageobjects;


public class FaceBookPage extends BasePage {

	private static FaceBookPage obj;
	
	private FaceBookPage(){
		//System.out.println("Constructor called FaceBookPage " + obj);
		super();
		page.put("fbTitle", "//a//i//u[text()='Facebook']");
		page.put("fbCreateAcctMsg","//span[text()='Create an account']");
		page.put("emailOrPhone", "//input[@id='email']");
		page.put("password", "//input[@id='pass']");
	}
	
	public static FaceBookPage getInstance()
	{
		if(obj == null){
			obj = new FaceBookPage();
		}
		System.out.println("Obj created FaceBookPage " + obj);
		return obj;
	}

}
