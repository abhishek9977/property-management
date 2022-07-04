package com.mycompany.propertymanagement1.repository;

import com.mycompany.propertymanagement1.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface Property_Repository extends CrudRepository<PropertyEntity,Long> {
}
