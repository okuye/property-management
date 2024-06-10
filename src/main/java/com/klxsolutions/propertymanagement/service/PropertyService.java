package com.klxsolutions.propertymanagement.service;

import com.klxsolutions.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
     PropertyDTO saveProperty(PropertyDTO propertyDTO);
     List<PropertyDTO> getAllProperties();
     List<PropertyDTO> getAllPropertiesForUser(Long userId);
     PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyId);
     PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO,Long propertyId);
     PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO,Long propertyId);
     void  deleteProperty(Long propertyId);
}
