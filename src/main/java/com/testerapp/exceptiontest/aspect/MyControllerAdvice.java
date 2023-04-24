package com.testerapp.exceptiontest.aspect;

import com.testerapp.exceptiontest.exception.CustomEx2;
import com.testerapp.exceptiontest.exception.CustomExA1;
import com.testerapp.exceptiontest.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class MyControllerAdvice
{

    Logger log= LoggerFactory.getLogger(MyControllerAdvice.class);

    @ExceptionHandler(value = CustomExA1.class)
    public ResponseEntity<?> handleA1(CustomExA1 ex1, WebRequest request)
   {
       log.info("Custom Exception message is :",ex1.getMessage());
       return new ResponseEntity(new ErrorResponse(ex1.getMessage(),5000,"Element Not Found"),HttpStatus.NOT_FOUND);
   }


    @ExceptionHandler(value = CustomEx2.class)
    public ResponseEntity<?> handleA2(CustomEx2 ex1)
    {
        return new ResponseEntity(new ErrorResponse(ex1.getMessage(),6000,"Element Not Correct"),HttpStatus.BAD_REQUEST);
    }
}
