package com.customexceptions;

public class UnableToLocateWebElementException extends RuntimeException{
    public UnableToLocateWebElementException(String exceptionMsg){
        super(exceptionMsg);
    }
}
