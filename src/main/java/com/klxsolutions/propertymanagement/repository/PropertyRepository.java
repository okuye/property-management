package com.klxsolutions.propertymanagement.repository;

import com.klxsolutions.propertymanagement.entity.PropertyEntity;

import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
