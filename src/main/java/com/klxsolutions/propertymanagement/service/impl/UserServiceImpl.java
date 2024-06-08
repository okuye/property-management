package com.klxsolutions.propertymanagement.service.impl;

import com.klxsolutions.propertymanagement.converter.UserConverter;
import com.klxsolutions.propertymanagement.dto.UserDTO;
import com.klxsolutions.propertymanagement.entity.UserEntity;
import com.klxsolutions.propertymanagement.repository.UserRepository;
import com.klxsolutions.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO LOGIN(String email, String password) {
        return null;
    }
}
