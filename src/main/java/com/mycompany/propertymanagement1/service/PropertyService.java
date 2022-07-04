package com.mycompany.propertymanagement1.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mycompany.propertymanagement1.dto.PropertyDTO;

import java.util.List;

public interface PropertyService
{

    public PropertyDTO saveproperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();

    public PropertyDTO updateproperty(PropertyDTO propertyDTO,Long propertyId);

    public PropertyDTO updateDescription(PropertyDTO propertyDTO,Long propertyId);

    public PropertyDTO updatePrice(PropertyDTO propertyDTO,Long propertyId);

    public void deleteProperty(Long propertyId);
}
