package com.mycompany.propertymanagement1.service;

import com.mycompany.propertymanagement1.dto.UserDTO;

public interface UserService
{
   UserDTO register(UserDTO userDTO);
   UserDTO login(String email,String password);
}
