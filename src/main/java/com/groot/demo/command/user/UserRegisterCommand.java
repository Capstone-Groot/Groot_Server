package com.groot.demo.command.user;

import com.groot.demo.dto.UserRegisterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterCommand {

    private String userId;

    private String password;

    private String userName;

    private String sellerCheck;

    public UserRegisterDto toDto() {
        return UserRegisterDto.builder()
                              .userName(userName)
                              .userId(userId)
                              .password(password)
                              .sellerCheck(sellerCheck)
                              .build();
    }

}
