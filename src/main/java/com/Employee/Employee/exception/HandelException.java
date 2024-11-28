package com.Employee.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandelException {

    @ExceptionHandler
    public ResponseEntity<ErrorsResponse> responseResponseEntity(ErrorNotFoundException exc){
        ErrorsResponse error=new ErrorsResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }@ExceptionHandler
    public ResponseEntity<ErrorsResponse> responseResponseEntity(Exception exc){
        ErrorsResponse error=new ErrorsResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
