package com.moviequote.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException {
    /**
     * overrides a RuntimeException occurrence passing in
     * @param message
     * returning a more precise error
     */
    public InformationExistException(String message) {
        super(message);
    }
}
