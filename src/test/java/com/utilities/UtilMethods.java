package com.utilities;

import com.customexceptions.EnvironmentPropertyNotFoundException;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UtilMethods {

    private static UtilMethods obj;
    LoadEnvirnmentProperties envProps;

    private UtilMethods(){
        envProps = LoadEnvirnmentProperties.getInstance();
    }

    public static UtilMethods getInstance(){
        if(obj == null){
            obj = new UtilMethods();
        }
        return obj;
    }

    public Long convertStringToLong(String str){
        return Long.parseLong(str);
    }

    public String getApplicationUrl(String applicationName) throws EnvironmentPropertyNotFoundException {
        String appToLoad = "";
        if (envProps.getEnvProperty("testEnvironment").equalsIgnoreCase("dev")) {
            if (applicationName.equalsIgnoreCase("FaceBook"))
                appToLoad = envProps.getEnvProperty("devFBAppUrl");
            if(applicationName.equalsIgnoreCase("Google"))
                appToLoad = envProps.getEnvProperty("devGoogleAppUrl");

        }else if (envProps.getEnvProperty("testEnvironment").equalsIgnoreCase("qa")) {
            if (applicationName.equalsIgnoreCase("FaceBook"))
                appToLoad = envProps.getEnvProperty("qaFBAppUrl");
            if(applicationName.equalsIgnoreCase("Google"))
                appToLoad = envProps.getEnvProperty("qaGoogleAppUrl");

        }else if (envProps.getEnvProperty("testEnvironment").equalsIgnoreCase("uat")) {
            if (applicationName.equalsIgnoreCase("FaceBook"))
                appToLoad = envProps.getEnvProperty("uatFBAppUrl");
            if(applicationName.equalsIgnoreCase("Google"))
                appToLoad = envProps.getEnvProperty("uatGoogleAppUrl");
        }
        return appToLoad;
    }

    public ArrayList getAllFilesInFolder(String folderPath) throws NullPointerException{

        ArrayList filesList = new ArrayList<String>();
        File folderToSearch = new File(folderPath);
        for (File f : folderToSearch.listFiles()) {
            if (f.isDirectory())
                getAllFilesInFolder(f.getAbsolutePath());
            filesList.add(f.getName());
        }
        return filesList;
    }

    public int convertStringToInt(String strValue){
        if(strValue.length()==0)
            return 0;
        return Integer.parseInt(strValue);
    }

    public String generateDate(String dateFormat, String noOfdays) {

        SimpleDateFormat sdf;
        String newDate;

        //Generate Current System date
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        //Add / Subtract no of days
        int intNoOfdays = convertStringToInt(noOfdays);
        System.out.println("No of Days:" + intNoOfdays);
        calendar.add(Calendar.DAY_OF_MONTH, intNoOfdays);
        sdf = new SimpleDateFormat(dateFormat);
        newDate = sdf.format(calendar.getTime());
        System.out.println("System Generated Date: " + newDate);
        return newDate;
    }

    public String getConstsVariableVaue(String varName){
        Object object;
        String value;
        try {
            Class constsClass = Class.forName("com.constants.Consts");
            final Field field = constsClass.getDeclaredField(varName);
            field.setAccessible(true);
            object = constsClass.newInstance();
            value = (String) field.get(object);
            return value;
        }
        catch (Exception e){
            return varName;
        }
    }

    public String getCurrentDateTestReportsFolder(){

        String folderLoc =  envProps.getEnvProperty("testReportsLoc") +
                            getCurrentTimePattern("yyyy") + "/" +
                            getCurrentTimePattern("MMM")  + "/" +
                            getCurrentTimePattern("dd")   + "/" +
                            getCurrentTimePattern("HH");

        File folder = new File(folderLoc);
        if(!folder.exists())
            folder.mkdirs();

        return  folderLoc;
    }

    public String getCurrentTimestamp(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String dtStr = dtf.format(now);
        System.out.println("CurrentTimeStamp: "+ dtStr);
        return  dtStr;
    }

    public String getCurrentTimePattern(String timePattern){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timePattern);;
        LocalDateTime now = LocalDateTime.now();
        String dtStr = "";

        switch (timePattern){
            case "yyyy": dtStr = "YY_" + dtf.format(now);
                        break;
            case "dd": dtStr = "DAY_" + dtf.format(now);
                        break;
            case "HH": dtStr = "HR_" + dtf.format(now);
                        break;
            case "MMM": dtStr = dtf.format(now);
                        break;
            default:dtStr = dtf.format(now);
        }
        return  dtStr;
    }

    public static void main(String[] args){
        UtilMethods obj = new UtilMethods();
        obj.getCurrentDateTestReportsFolder();
    }
}
