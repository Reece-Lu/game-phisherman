package com.example.fisherman_server.controller;

import com.example.fisherman_server.common.Result;
import com.example.fisherman_server.controller.DTO.UserLoginDTO;
import com.example.fisherman_server.entity.User;
import com.example.fisherman_server.service.AccountService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/fisherman/account")
@Resource
public class AccountController {

    @Autowired
    AccountService accountService;

    @ApiOperation(value = "login",notes = "if username not valid, user id = -1; if password is not valid, user id = -2; else is the normal user class")
    @PostMapping("/login")
    public Result loginForPropertyManagement(@RequestBody UserLoginDTO userLoginDTO){
        User user = accountService.login(userLoginDTO);

        if(user!=null){
            return Result.success(user);
        }else{
            return Result.error();
        }
    }

}



