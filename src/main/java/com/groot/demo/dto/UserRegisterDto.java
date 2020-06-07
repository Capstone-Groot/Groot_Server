package com.groot.demo.dto;

import com.groot.demo.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRegisterDto {

    private String userId;

    private String password;

    private String userName;

    private String checkSeller;

    @Builder
    public UserRegisterDto(String userId, String password, String userName, String checkSeller) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.checkSeller = checkSeller;
    }

    public User toEntity() {
        return User.builder()
                   .userName(userName)
                   .userId(userId)
                   .password(password)
                   .checkSeller(checkSeller)
                   .build();
    }
}
