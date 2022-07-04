package com.mycompany.propertymanagement1.repository;


import com.mycompany.propertymanagement1.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface User_Repository extends CrudRepository<UserEntity,Long>
{
    Optional<UserEntity> findByOwnerEmailAndPassword(String email, String password);
}
