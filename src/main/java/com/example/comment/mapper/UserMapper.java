package com.example.comment.mapper;

import com.example.comment.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

    @Insert("""
            INSERT INTO user (username,password_hash,nickname,phone,email) VALUES (#{username},#{password},#{nickname},#{phone},#{email})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addUserMapper(User user);
}
