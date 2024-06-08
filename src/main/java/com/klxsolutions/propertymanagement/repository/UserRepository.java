package com.klxsolutions.propertymanagement.repository;

import com.klxsolutions.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
