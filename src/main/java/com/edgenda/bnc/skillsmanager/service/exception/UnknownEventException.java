package com.edgenda.bnc.skillsmanager.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownEventException extends RuntimeException {

    public UnknownEventException(Long id) {
        super("Unknown Event with ID=" + id);
    }

}
