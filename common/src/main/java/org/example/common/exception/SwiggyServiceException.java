package org.example.common.exception;

import org.springframework.stereotype.Component;


public class SwiggyServiceException extends RuntimeException{

    public SwiggyServiceException(String message) {
        super(message);
    }
}
