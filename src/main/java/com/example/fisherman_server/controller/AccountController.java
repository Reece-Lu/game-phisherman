package com.example.fisherman_server.controller;

import com.example.fisherman_server.common.Result;
import com.example.fisherman_server.controller.DTO.UserLoginDTO;
import com.example.fisherman_server.controller.DTO.UserRegisterDTO;
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
    public Result loginForUser(@RequestBody UserLoginDTO userLoginDTO){
        User user = accountService.login(userLoginDTO);

        if(user!=null){
            return Result.success(user);
        }else{
            return Result.error();
        }
    }

    @ApiOperation(value = "register",notes = "input 'username','password','nickname','email'. And if registed successfully 'data' equals 1")
    @PostMapping("/register")
    public Result registerForUser(@RequestBody UserRegisterDTO userRegisterDTO){

        if(accountService.register(userRegisterDTO)==1){
            return Result.success("1");
        }else{
            return Result.error();
        }
    }



}



