package com.sitebuilder.aero.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sitebuilder.aero.model.ErrorInfo;

/**
 * @author pbonansea
 *
 */
@ControllerAdvice
public class ArgumentExceptionControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.PRECONDITION_REQUIRED)
    public @ResponseBody ErrorInfo exception(Exception ex) {
        
        return new ErrorInfo(HttpStatus.PRECONDITION_REQUIRED, "", ex.getMessage());
        
    }
    
}
