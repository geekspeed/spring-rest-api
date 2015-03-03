package com.sitebuilder.aero.model;

import lombok.Value;

import org.springframework.http.HttpStatus;

/**
 * @author pbonansea
 *
 */
@Value
public class ErrorInfo {

    private final HttpStatus httpStatus;

    private final String errorCode;
    
    private final String errorMessage;
    
}
