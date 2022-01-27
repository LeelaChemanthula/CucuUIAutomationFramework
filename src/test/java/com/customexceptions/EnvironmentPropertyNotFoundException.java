package com.customexceptions;

public class EnvironmentPropertyNotFoundException extends RuntimeException{
    public EnvironmentPropertyNotFoundException(String exceptionMsg){
        super(exceptionMsg);
    }
}
