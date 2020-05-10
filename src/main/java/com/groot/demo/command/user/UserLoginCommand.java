package com.groot.demo.command.user;

import com.groot.demo.dto.UserLoginDto;
import com.groot.demo.dto.UserRegisterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginCommand {

    private String userId;
    private String password;

    public UserLoginDto toDto() {
        return UserLoginDto.builder()
                              .userId(userId)
                              .password(password)
                              .build();
    }
}
