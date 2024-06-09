package com.klxsolutions.propertymanagement.service;

import com.klxsolutions.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO login(String email, String password);
}
