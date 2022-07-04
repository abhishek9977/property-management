package com.mycompany.propertymanagement1.service.impl;

import com.mycompany.propertymanagement1.convertor.UserConvertor;
import com.mycompany.propertymanagement1.dto.UserDTO;
import com.mycompany.propertymanagement1.entity.UserEntity;
import com.mycompany.propertymanagement1.repository.User_Repository;
import com.mycompany.propertymanagement1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private User_Repository userrepository;

    @Autowired
    private UserConvertor userConvertor;

    @Override
    public UserDTO register(UserDTO userDTO)
    {
        UserEntity ue=userConvertor.convertDtoToEntity(userDTO);
        ue=userrepository.save(ue);
        userDTO=userConvertor.converEntitytToDto(ue);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password)
    {
        UserDTO userDTO=null;
       Optional<UserEntity> ue= userrepository.findByOwnerEmailAndPassword(email, password);
        if(ue.isPresent())
        {
         userDTO=userConvertor.converEntitytToDto(ue.get());


        }
       return userDTO;
    }
}
