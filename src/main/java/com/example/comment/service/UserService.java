package com.example.comment.service;


import com.example.comment.dto.CreateUserRequest;
import com.example.comment.entity.User;
import com.example.comment.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    public void addUserService(CreateUserRequest createUserRequest){
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());
        if(createUserRequest.getNickname()==null){
            String value = "";
            user.setNickname(value);
        }else {
            user.setNickname(createUserRequest.getNickname());
        }

        if (createUserRequest.getEmail() == null){
            String value = null;
            user.setEmail(value);
        }else {
            user.setEmail(createUserRequest.getEmail());
        }
        if (createUserRequest.getPhone() == null){
            String value = null;
            user.setPhone(value);
        }else {
            user.setPhone(createUserRequest.getPhone());
        }

        userMapper.addUserMapper(user);
    }
}
