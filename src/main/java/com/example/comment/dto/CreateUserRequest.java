package com.example.comment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "用户名格式错误或不能为空;")
    @Size(max = 32,min = 1)
    private String username;
    @Size(max = 16,min = 6)
    @NotBlank(message = "密码不为空;")
    private String password;
//    @NotEmpty(message = "不能为空字符串")
    @Size(min = 1,max = 32)
    private String nickname;
    @Size(min = 6,max = 20)
    private String phone;
    @Email
    @Size(max = 64)
    private String email;
}
