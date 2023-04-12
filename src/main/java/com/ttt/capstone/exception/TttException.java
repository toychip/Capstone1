package com.ttt.capstone.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class TttException extends RuntimeException{

    public Map<String, String> validaion = new HashMap<>();

    public TttException(String message) {
        super(message);
    }

    public TttException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message){
        validaion.put(fieldName, message);
    }
}
