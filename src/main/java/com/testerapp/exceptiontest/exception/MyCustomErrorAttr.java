package com.testerapp.exceptiontest.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyCustomErrorAttr extends DefaultErrorAttributes
{

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String,Object> errorMap= super.getErrorAttributes(webRequest, options);
        errorMap.put("Tax","Not Taxable");

        return errorMap;
    }
}
