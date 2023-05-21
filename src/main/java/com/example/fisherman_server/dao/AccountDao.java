package com.example.fisherman_server.dao;

import com.example.fisherman_server.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao {

//    used for checking the inputted username is existed or not
    Integer loginCheckUsernameExisted(String username);
//    get a particular user's info used for server judge whether the password is valid
    User loginGetUserInfo(String username);

}
