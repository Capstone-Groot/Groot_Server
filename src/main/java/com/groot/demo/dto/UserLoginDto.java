package com.groot.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserLoginDto {

    private String userId;

    private String password;

    @Builder
    public UserLoginDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

}
