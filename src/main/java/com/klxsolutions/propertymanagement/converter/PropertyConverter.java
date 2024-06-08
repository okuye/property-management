package com.klxsolutions.propertymanagement.converter;

import com.klxsolutions.propertymanagement.dto.PropertyDTO;
import com.klxsolutions.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setAddress(propertyDTO.getAddress());
//        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
//        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setPrice(propertyDTO.getPrice().toString());
        propertyEntity.setDescription(propertyDTO.getDescription());

        return propertyEntity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
//        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
//        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setPrice(propertyEntity.getPrice().toString());
        propertyDTO.setDescription(propertyEntity.getDescription());

        return propertyDTO;
    }
}
