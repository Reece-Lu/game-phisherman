package com.example.fisherman_server.service;

import com.example.fisherman_server.controller.DTO.UserLoginDTO;
import com.example.fisherman_server.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
//    The service for check whether an account is existed, and if it is, check whether the password is valid.
//    if not return user id = -1; if it is return the info of the user.
    User login(UserLoginDTO userLoginDTO);
}
