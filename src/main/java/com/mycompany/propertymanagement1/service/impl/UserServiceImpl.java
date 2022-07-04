package com.mycompany.propertymanagement1.service.impl;

import com.mycompany.propertymanagement1.convertor.UserConvertor;
import com.mycompany.propertymanagement1.dto.UserDTO;
import com.mycompany.propertymanagement1.entity.UserEntity;
import com.mycompany.propertymanagement1.exception.BusinessException;
import com.mycompany.propertymanagement1.exception.ErrorModel1;
import com.mycompany.propertymanagement1.repository.User_Repository;
import com.mycompany.propertymanagement1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        Optional<UserEntity> opt=userrepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(opt.isPresent())
        {
            List<ErrorModel1> errorModel1List=new ArrayList<>();
            ErrorModel1 errorModel1=new ErrorModel1();
            errorModel1.setCode("EMAIL_ALREADY_EXIST");
            errorModel1.setMessage("TRY TO REGISTER WITH ANOTHER EMAIL");
            errorModel1List.add(errorModel1);

            throw new BusinessException(errorModel1List);
        }
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
        else
        {
            List<ErrorModel1> errorModel1List=new ArrayList<>();
            ErrorModel1 errorModel1=new ErrorModel1();
            errorModel1.setCode("INVALID_LOGIN");
            errorModel1.setMessage("INVALID EMAIL AND PASSWORD");
            errorModel1List.add(errorModel1);

            throw new BusinessException(errorModel1List);
        }
       return userDTO;
    }
}
