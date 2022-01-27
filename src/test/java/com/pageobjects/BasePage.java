package com.pageobjects;

import com.customexceptions.PageObjectNotFoundException;

import java.util.HashMap;

public abstract class BasePage{

	public HashMap<String, String> page = new HashMap<String, String>();
	public String pageName = "";

	public BasePage(){
		this.pageName = this.getClass().getSimpleName();
	}

	public String getXpath (String xpathKey) throws PageObjectNotFoundException
	{
		String xpathValue = null;
		if (page.containsKey(xpathKey)) {
			xpathValue = page.get(xpathKey);
			return xpathValue;
		}
		else throw new PageObjectNotFoundException("\"" + xpathKey+ "\"" + " not found in page " + "\"" +pageName +".java" + "\"");
	}
}
