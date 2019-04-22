package com.edgenda.bnc.skillsmanager.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownOwnerException extends RuntimeException{
    public UnknownOwnerException(String owner) {
        super("Unknown Event with owner=" + owner);
    }
}