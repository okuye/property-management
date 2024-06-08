package com.klxsolutions.propertymanagement.service;

import com.klxsolutions.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO LOGIN(String email,String password);
}
