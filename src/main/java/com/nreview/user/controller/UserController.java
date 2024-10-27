package com.nreview.user.controller;

import com.nreview.user.dto.UserDto;
import com.nreview.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private  UserService userService;


    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserDto userDTO){
       userService.saveToDb(userDTO);
        return "User registered successfully";
    }
}
