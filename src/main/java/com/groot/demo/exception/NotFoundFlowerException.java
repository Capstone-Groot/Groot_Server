package com.groot.demo.exception;

public class NotFoundFlowerException extends RuntimeException {
    public NotFoundFlowerException(String message){
        super( message);
    }
}
