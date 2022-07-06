package com.mycompany.propertymanagement1.Controller;


import com.mycompany.propertymanagement1.dto.PropertyDTO;
import com.mycompany.propertymanagement1.dto.UserDTO;
import com.mycompany.propertymanagement1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController
{

    @Autowired
    private UserService  userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> saveproperty(@Valid @RequestBody UserDTO userDTO)
    {
        userDTO=userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity= new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO)
    {
        userDTO=userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
        ResponseEntity<UserDTO> responseEntity= new ResponseEntity<>(userDTO, HttpStatus.OK);
        return responseEntity;
    }
}
