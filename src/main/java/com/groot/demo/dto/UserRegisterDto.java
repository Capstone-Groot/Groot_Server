package com.groot.demo.dto;

import com.groot.demo.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRegisterDto {

    private String userId;

    private String password;

    private String userName;

    @Builder
    public UserRegisterDto(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    public User toEntity() {
        return User.builder()
                   .userName(userName)
                   .userId(userId)
                   .password(password)
                   .build();
    }
}
