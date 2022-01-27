package com.customexceptions;

public class PageClassNotFoundException extends RuntimeException{

    public PageClassNotFoundException(String exceptionMsg){
        super(exceptionMsg);
    }
}
