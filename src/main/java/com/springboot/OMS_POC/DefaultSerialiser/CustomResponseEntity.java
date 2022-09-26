package com.springboot.OMS_POC.DefaultSerialiser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class CustomResponseEntity extends ResponseEntity implements Serializable
{
    public CustomResponseEntity(HttpStatus status) {
        super(status);
    }
}
