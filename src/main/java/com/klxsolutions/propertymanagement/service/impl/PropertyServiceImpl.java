package com.klxsolutions.propertymanagement.service.impl;

import com.klxsolutions.propertymanagement.converter.PropertyConverter;
import com.klxsolutions.propertymanagement.dto.PropertyDTO;
import com.klxsolutions.propertymanagement.entity.PropertyEntity;
import com.klxsolutions.propertymanagement.entity.UserEntity;
import com.klxsolutions.propertymanagement.exception.BusinessException;
import com.klxsolutions.propertymanagement.exception.ErrorModel;
import com.klxsolutions.propertymanagement.repository.PropertyRepository;
import com.klxsolutions.propertymanagement.repository.UserRepository;
import com.klxsolutions.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        Optional<UserEntity> optUe = userRepository.findById(propertyDTO.getUserId());
    if (optUe.isPresent()) {
      PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
      pe.setUserEntity(optUe.get());
      pe = propertyRepository.save(pe);
      propertyDTO = propertyConverter.convertEntityToDTO(pe);
        }
    else {
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("USER_ID_DOES_NOT_EXIST");
        errorModel.setMessage("User does not exist");
        errorModelList.add(errorModel);

        throw new BusinessException(errorModelList);
    }
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
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
        return List.of();
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity propertyEntity = optEn.get(); //Data from the database
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setPrice(propertyDTO.getPrice());
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
