package com.mycompany.propertymanagement1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;



@ControllerAdvice
public class CustomExceptionHandler
{

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<java.util.List<ErrorModel1>> handleBusinessException(BusinessException bex)
    {
        System.out.println("Buinessexecption is thrown");
        return new ResponseEntity<List<ErrorModel1>>(bex.getErrors(),HttpStatus.BAD_REQUEST);
    }

}
