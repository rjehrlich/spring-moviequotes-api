package com.moviequote.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{
    /**
     * overrides a RuntimeException occurrence passing in
     * @param message
     * returning a more precise error
     */
    public InformationNotFoundException(String message) {
        super(message);
    }
}
