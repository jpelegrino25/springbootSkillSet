package com.julioluis.springbootskillset.util;

public class BusinessException extends Exception {

    private String message;

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
