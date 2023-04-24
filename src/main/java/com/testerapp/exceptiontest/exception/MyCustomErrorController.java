package com.testerapp.exceptiontest.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//@RestController
public class MyCustomErrorController implements ErrorController
{
    @Autowired
    private ErrorAttributes errorAttributes;


    /*
    @RequestMapping("/error")
    public ModelAndView handleErrorHTML(HttpServletRequest req)
    {

        ServletWebRequest webRequest= new ServletWebRequest(req);
        ErrorAttributeOptions options = ErrorAttributeOptions
                .defaults()
                .including(ErrorAttributeOptions.Include.MESSAGE)
                .including(ErrorAttributeOptions.Include.STACK_TRACE);

       Map<String,Object> errorMap= errorAttributes.getErrorAttributes(webRequest,options);
       errorMap.put("Title","MyExceptionTest");

       ModelAndView mv= new ModelAndView();
       mv.setViewName("error");
       mv.addAllObjects(errorMap);

       System.out.println(errorMap);

       return mv;

    }

     */


    @RequestMapping("/error")
    public Map<String,Object> handleError(HttpServletRequest req)
    {


        System.out.println(errorAttributes);

        ServletWebRequest webRequest= new ServletWebRequest(req);
        ErrorAttributeOptions options=ErrorAttributeOptions.defaults()
                .including(ErrorAttributeOptions.Include.MESSAGE)
                .including(ErrorAttributeOptions.Include.STACK_TRACE)
                .including(ErrorAttributeOptions.Include.EXCEPTION);


        Map<String,Object> errorMap= errorAttributes.getErrorAttributes(webRequest,options);
        errorMap.put("Content Type","Json");


        System.out.println(errorMap);

        return errorMap;

        /*
  ResponseEntity.status()
                .headers()
                .body(errorMap)

         */
    }



}
