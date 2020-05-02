package com.groot.demo.api;

import com.groot.demo.command.LoginUserCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping("/login")
    public String login(@RequestBody LoginUserCommand userCommand){

        System.out.println(userCommand);
        return "success";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
