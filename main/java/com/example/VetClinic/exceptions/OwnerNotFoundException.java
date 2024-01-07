package com.example.VetClinic.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException (String message){
        super(message);
    }
}
