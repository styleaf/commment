package com.example.comment.controller;

import com.example.comment.dto.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comment.entity.Result;
import com.example.comment.entity.User;
import com.example.comment.service.UserService;

@RestController
// = @Controller + @ResponseBody
// 加 @ResponseBody 意味着可以讲东西转化成json格式
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result addUser(@Valid  @RequestBody CreateUserRequest createUserRequest) {
        userService.addUserService(createUserRequest);
        return Result.success();
    }
}
