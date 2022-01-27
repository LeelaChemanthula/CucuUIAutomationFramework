package com.pageobjects;

import com.customexceptions.PageClassNotFoundException;
import com.utilities.LoadEnvirnmentProperties;
import com.utilities.UtilMethods;

import java.util.ArrayList;

public class PageObjectFactory {

    private static PageObjectFactory obj;

    LoadEnvirnmentProperties envProps;
    UtilMethods utilMethods;
    ArrayList allPageObjectFiles;
    BasePage pageObj;

    public PageObjectFactory(){
        envProps = LoadEnvirnmentProperties.getInstance();
        utilMethods = UtilMethods.getInstance();
    }

    public static PageObjectFactory getInstance(){
        if(obj == null){
            obj = new PageObjectFactory();
        }
        return obj;
    }

    public BasePage getPageObj(String pageName) throws PageClassNotFoundException{

        String pageObjectsPath = envProps.getEnvProperty("projectLoc") + "/src/test/java/com/pageobjects";
        allPageObjectFiles = utilMethods.getAllFilesInFolder(pageObjectsPath);

        if(allPageObjectFiles.contains(pageName+".java")) {
            switch (pageName) {

                case "GooglePage":  pageObj = GooglePage.getInstance();
                                    //pageObj.pageName = pageName;
                                    break;
                case "FaceBookPage":pageObj = FaceBookPage.getInstance();
                                    //pageObj.pageName = pageName;
                                    break;
                case "GmailPage":   pageObj = GmailPage.getInstance();
                                    //pageObj.pageName = pageName;
                                    break;
            }
        }else{
            throw new PageClassNotFoundException("\"" + pageName + ".java" + "\"" +" does not exist under " + pageObjectsPath);
        }

        return pageObj;
    }

}
