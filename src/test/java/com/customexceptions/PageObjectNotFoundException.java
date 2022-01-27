package com.customexceptions;

public class PageObjectNotFoundException extends RuntimeException{

    public PageObjectNotFoundException(String exceptionMsg){
        super(exceptionMsg);
    }
}
