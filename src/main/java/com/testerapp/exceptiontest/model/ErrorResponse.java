package com.testerapp.exceptiontest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse
{

    private String msg;
    private int code;
    private String status;
}
