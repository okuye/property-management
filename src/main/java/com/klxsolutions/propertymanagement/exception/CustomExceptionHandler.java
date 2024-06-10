package com.klxsolutions.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> HandleFieldValidation(MethodArgumentNotValidException warn){
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorsList = warn.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrorsList) {
            logger.debug("BusinessException is thrown: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            logger.info("BusinessException is thrown: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fieldError.getField());
            errorModel.setMessage(fieldError.getDefaultMessage());
            errorModelList.add(errorModel);
        }

        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException) {
        for(ErrorModel em: businessException.getErrors()) {
            logger.debug("BusinessException is thrown: {} - {}", em.getCode(), em.getMessage());
            logger.info("BusinessException is thrown: {} - {}", em.getCode(), em.getMessage());

        }

        return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
