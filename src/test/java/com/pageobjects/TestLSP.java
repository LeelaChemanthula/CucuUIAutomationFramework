package com.pageobjects;

public class TestLSP {
    public static void main(String[] args) {

        PageObjectFactory pageObjectFactory = new PageObjectFactory();

        BasePage bPage = pageObjectFactory.getPageObj("FaceBookPage");
        String xpath = bPage.getXpath("fbTitle");
        System.out.println("Xpath: " + xpath);

        bPage = pageObjectFactory.getPageObj("GooglePage");
        xpath = bPage.getXpath("googleTitle");
        System.out.println("Xpath: " + xpath) ;
    }
}
