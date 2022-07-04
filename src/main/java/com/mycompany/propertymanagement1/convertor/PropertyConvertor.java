package com.mycompany.propertymanagement1.convertor;

import com.mycompany.propertymanagement1.dto.PropertyDTO;
import com.mycompany.propertymanagement1.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConvertor
{

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO)
    {
        PropertyEntity pe=new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());

        return pe;
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity)
    {
        PropertyDTO pd=new PropertyDTO();
        pd.setId(propertyEntity.getId());
        pd.setTitle(propertyEntity.getTitle());
        pd.setAddress(propertyEntity.getAddress());
        pd.setDescription(propertyEntity.getDescription());
       pd.setPrice(propertyEntity.getPrice());

        return pd;
    }

}
