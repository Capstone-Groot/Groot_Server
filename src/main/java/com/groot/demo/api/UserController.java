package com.groot.demo.api;

import com.groot.demo.command.user.UserLoginCommand;
import com.groot.demo.command.user.UserRegisterCommand;
import com.groot.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegisterCommand userRegisterCommand) {

        return userService.register(userRegisterCommand.toDto());
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginCommand userLoginCommand) {

        return userService.login(userLoginCommand.toDto());
    }

}
