package com.assignment.Defense.of.the.Ancients2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is ServiceLevelException class for taking exceptions with invalid requests.
 * @author karan.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceLevelException extends RuntimeException {
    public ServiceLevelException(Exception exception) {
        super(exception);
    }
}
