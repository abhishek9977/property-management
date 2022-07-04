package com.mycompany.propertymanagement1.Controller;

import com.mycompany.propertymanagement1.dto.PropertyDTO;
import com.mycompany.propertymanagement1.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController
{
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello()
    {
        return "hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveproperty(@RequestBody PropertyDTO propertyDTO)
    {
        propertyDTO=propertyService.saveproperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties1")
    public ResponseEntity<List<PropertyDTO>> getAllProperty()
    {
         List<PropertyDTO> propertyList=propertyService.getAllProperties();
         ResponseEntity<List<PropertyDTO>> responseEntity=new ResponseEntity<>(propertyList, HttpStatus.OK);
         return responseEntity;

    }


    @PutMapping("/properties2/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDTO(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId)
    {
        propertyDTO =propertyService.updateproperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties3/{propertyId}")
    public  ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId)
    {
        propertyDTO=propertyService.updateDescription(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties4/{propertyId}")
    public  ResponseEntity<PropertyDTO> updateprice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId)
    {
       propertyDTO= propertyService.updatePrice(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties5/{productId}")
    public ResponseEntity<Void> deleteproperty(@PathVariable Long productId)
    {

        propertyService.deleteProperty(productId);
        ResponseEntity<Void> responseEntity=new ResponseEntity<>( HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
