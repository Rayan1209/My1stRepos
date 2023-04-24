package com.testerapp.exceptiontest.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class CustomErrorControllerWithCustomAttr  extends AbstractErrorController
{
    public CustomErrorControllerWithCustomAttr(ErrorAttributes errorAttributes)
    {

        super(errorAttributes);
    }

    @RequestMapping("/error")
    public Map<String,Object> handleError(HttpServletRequest req)
    {
      Map<String,Object> errorMap=  super.getErrorAttributes(req,ErrorAttributeOptions.defaults()
                .including(ErrorAttributeOptions.Include.MESSAGE)
                .including(ErrorAttributeOptions.Include.EXCEPTION));

      log.info("Error Attributes are as follows",errorMap);

      return  errorMap;




    }
}
