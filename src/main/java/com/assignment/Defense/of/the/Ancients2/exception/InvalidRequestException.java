package com.assignment.Defense.of.the.Ancients2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is InvalidRequestException class for taking exceptions with invalid requests.
 * @author karan.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String exception) {
        super(exception);
    }
}
