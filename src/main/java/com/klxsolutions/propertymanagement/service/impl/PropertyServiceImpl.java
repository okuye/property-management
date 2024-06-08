package com.klxsolutions.propertymanagement.service.impl;

import com.klxsolutions.propertymanagement.converter.PropertyConverter;
import com.klxsolutions.propertymanagement.dto.PropertyDTO;
import com.klxsolutions.propertymanagement.entity.PropertyEntity;
import com.klxsolutions.propertymanagement.repository.PropertyRepository;
import com.klxsolutions.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private  PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter  propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
      PropertyEntity pe =  propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        propertyDTO = propertyConverter.convertEntityToDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();

        for(PropertyEntity propertyEntity : listOfProps){
            PropertyDTO dto = propertyConverter.convertEntityToDTO(propertyEntity);
            propertyDTOList.add(dto);
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity propertyEntity = optEn.get(); //Data from the database
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setPrice(propertyDTO.getPrice().toString());
            propertyEntity.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity propertyEntity = optEn.get(); //Data from the database
            propertyEntity.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity propertyEntity = optEn.get(); //Data from the database
            propertyEntity.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
