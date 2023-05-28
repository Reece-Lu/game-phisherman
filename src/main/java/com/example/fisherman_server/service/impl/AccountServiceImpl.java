package com.example.fisherman_server.service.impl;

import com.example.fisherman_server.controller.DTO.UserLoginDTO;
import com.example.fisherman_server.controller.DTO.UserRegisterDTO;
import com.example.fisherman_server.dao.AccountDao;
import com.example.fisherman_server.entity.User;
import com.example.fisherman_server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    public User login(UserLoginDTO userLoginDTO){
        String username = userLoginDTO.getUsername();


        if (accountDao.loginCheckUsernameExisted(username) != 0){
            User user = accountDao.loginGetUserInfo(username);

            if(user.getPassword().equals(userLoginDTO.getPassword())) {
                user.setPassword(null);
                return user;
            }else{
                // if the password is wrong, set user id equals -2;
                user.setId(-2);
                user.setUsername(null);
                user.setPassword(null);
                user.setNickname(null);
                user.setEmail(null);
            }
            return user;
        }
//      if the username is not existed, return a user object with a user if equals -1;
        User user = new User(){{setId(-1);}};
        return user;
    }

    @Override
    public Integer register(UserRegisterDTO userRegisterDTO) {
        String username = userRegisterDTO.getUsername();
        String password = userRegisterDTO.getPassword();
        String nickname = userRegisterDTO.getNickname();
        String email = userRegisterDTO.getEmail();

        return accountDao.registerUser(username,password,nickname,email);
    }
}
