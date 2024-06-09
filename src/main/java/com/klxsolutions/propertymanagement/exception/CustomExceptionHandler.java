package com.klxsolutions.propertymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException) {
        System.out.println("BusinessException is thrown");
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}