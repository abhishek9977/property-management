package com.mycompany.propertymanagement1.service.impl;

import com.mycompany.propertymanagement1.convertor.PropertyConvertor;
import com.mycompany.propertymanagement1.dto.PropertyDTO;

import com.mycompany.propertymanagement1.entity.PropertyEntity;
import com.mycompany.propertymanagement1.repository.Property_Repository;
import com.mycompany.propertymanagement1.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService
{
    @Autowired
    private Property_Repository propertyRepository;

    @Autowired
    private PropertyConvertor propertyConvertor;

    @Override
    public PropertyDTO saveproperty(PropertyDTO propertyDTO)
    {
      PropertyEntity pe= propertyConvertor.convertDTOtoEntity(propertyDTO);
        pe=propertyRepository.save(pe);
        PropertyDTO pd=propertyConvertor.convertEntitytoDTO(pe);
        return pd;
    }

    @Override
    public List<PropertyDTO> getAllProperties()
    {
       List<PropertyEntity> propertyDTOList=(List<PropertyEntity>) propertyRepository.findAll();
       List<PropertyDTO> listDTO=new ArrayList<>();
       for(PropertyEntity pe:propertyDTOList)
       {
          PropertyDTO dto= propertyConvertor.convertEntitytoDTO(pe);
          listDTO.add(dto);
       }
       return listDTO;

    }

    @Override
    public PropertyDTO updateproperty(PropertyDTO propertyDTO, Long propertyId)
    {
        Optional<PropertyEntity> opten=propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(opten.isPresent())
        {
            PropertyEntity pe=opten.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());

            dto=propertyConvertor.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyId)
    {
        Optional<PropertyEntity> opten=propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(opten.isPresent())
        {
            PropertyEntity pe=opten.get();
            pe.setDescription(propertyDTO.getDescription());
            dto=propertyConvertor.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long propertyId)
    {
        Optional<PropertyEntity> opten=propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(opten.isPresent())
        {
            PropertyEntity pe=opten.get();
            pe.setPrice(propertyDTO.getPrice());
            dto= propertyConvertor.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId)
    {
        propertyRepository.deleteById(propertyId);
    }

}
