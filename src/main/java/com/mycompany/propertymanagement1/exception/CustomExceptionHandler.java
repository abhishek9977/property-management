package com.mycompany.propertymanagement1.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;



@ControllerAdvice
public class CustomExceptionHandler
{

    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<ErrorModel1>> handleFieldValidation(MethodArgumentNotValidException me)
    {
        List<ErrorModel1> errorModel1List=new ArrayList<>();
        ErrorModel1 errorModel1=null;
        List<FieldError> fieldErrors=me.getBindingResult().getFieldErrors();

        for(FieldError fe:fieldErrors) {
            logger.info("Inside field validation {} - {}",fe.getField(),fe.getDefaultMessage());
            logger.debug("Inside field validation {} - {}",fe.getField(),fe.getDefaultMessage());
            errorModel1 = new ErrorModel1();
            errorModel1.setMessage(fe.getDefaultMessage());
            errorModel1.setCode(fe.getField());
            errorModel1List.add(errorModel1);
        }
            return new ResponseEntity<List<ErrorModel1>>(errorModel1List,HttpStatus.BAD_REQUEST);



    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<java.util.List<ErrorModel1>> handleBusinessException(BusinessException bex)
    {
        for(ErrorModel1 fe: bex.getErrors())
        {
            logger.info("Inside field validation {} - {}",fe.getCode(),fe.getMessage());
            logger.debug("Inside field validation {} - {}",fe.getCode(),fe.getMessage());
            logger.warn("Inside field validation {} - {}",fe.getCode(),fe.getMessage());
            logger.error("Inside field validation {} - {}",fe.getCode(),fe.getMessage());
        }
        System.out.println("Buinessexecption is thrown");
        return new ResponseEntity<List<ErrorModel1>>(bex.getErrors(),HttpStatus.BAD_REQUEST);
    }

}
