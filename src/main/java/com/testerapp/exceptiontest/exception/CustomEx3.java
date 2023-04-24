package com.testerapp.exceptiontest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(code= HttpStatus.NOT_IMPLEMENTED)
public class CustomEx3 extends RuntimeException

{

    private static final long serialVersionUID = -6773059715754293350L;

    public CustomEx3()
    {

    }
   public CustomEx3(String msg)
    {
        super(msg);
    }
}
