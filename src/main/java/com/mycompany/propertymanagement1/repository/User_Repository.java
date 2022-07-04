package com.mycompany.propertymanagement1.repository;

import com.mycompany.propertymanagement1.entity.PropertyEntity;
import com.mycompany.propertymanagement1.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface User_Repository extends CrudRepository<UserEntity,Long> {
}
