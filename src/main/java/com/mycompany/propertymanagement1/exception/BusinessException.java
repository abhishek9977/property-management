package com.mycompany.propertymanagement1.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException
{
    private List<ErrorModel1> errors;



    public  BusinessException(List<ErrorModel1> errors)

    {
        this.errors=errors;
    }

}
