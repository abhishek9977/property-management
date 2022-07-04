package com.mycompany.propertymanagement1.convertor;

import com.mycompany.propertymanagement1.dto.UserDTO;
import com.mycompany.propertymanagement1.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor
{
    public UserEntity convertDtoToEntity(UserDTO userDTO)
    {
        UserEntity ue=new UserEntity();
        ue.setOwnerEmail(userDTO.getOwnerEmail());
        ue.setOwnerName(userDTO.getOwnerName());
        ue.setPassword(userDTO.getPassword());
        ue.setPhone(userDTO.getPhone());

        return ue;
    }
    public UserDTO converEntitytToDto(UserEntity userEntity)
    {
        UserDTO ud=new UserDTO();
        ud.setOwnerName(userEntity.getOwnerName());
        ud.setOwnerEmail(userEntity.getOwnerEmail());
        ud.setId(userEntity.getId());
        ud.setPhone(userEntity.getPhone());
        return ud;
    }
    {

    }
}
