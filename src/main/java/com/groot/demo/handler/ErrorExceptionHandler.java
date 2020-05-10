package com.groot.demo.handler;

import com.groot.demo.exception.DuplicationException;
import com.groot.demo.exception.LoginException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(value = DuplicationException.class)
    public ResponseEntity handleDuplicationException(DuplicationException exception) {

        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(exception.getMessage());
    }

    @ExceptionHandler(value = LoginException.class)
    public ResponseEntity handleLoginException(LoginException exception) {

        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(exception.getMessage());
    }


}
