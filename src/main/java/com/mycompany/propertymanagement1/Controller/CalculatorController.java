package com.mycompany.propertymanagement1.Controller;

import com.mycompany.propertymanagement1.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController
{
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2)
    {
        return num1 + num2;
    }

   @GetMapping("/sub/{num1}/{num2}")
    public Double sub(@PathVariable Double num1,@PathVariable Double num2)
    {
        if(num1>num2)
        {

            return num1 - num2;
        }
        else
        {
            return num2 - num2;
        }
    }

    @PostMapping("/multi")
    public ResponseEntity<Double> multi(@RequestBody CalculatorDTO calculatorDTO)
    {
        Double result=null;
        result=calculatorDTO.getNum1()* calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity=new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
