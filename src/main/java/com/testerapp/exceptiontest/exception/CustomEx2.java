package com.testerapp.exceptiontest.exception;

public class CustomEx2 extends Exception
{
    private String message;

    public CustomEx2(){}
    public  CustomEx2(String msg)
    {
        super(msg);
        this.message=msg;

    }

}
