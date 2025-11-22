package com.mongodbflux.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException exception) {

        Map<String, String> errorMap = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(error -> {

            String fieldName;

            if (error instanceof FieldError) {
                fieldName = ((FieldError) error).getField();
            } else {
                fieldName = error.getObjectName();  
            }

            String message = error.getDefaultMessage();
            errorMap.put(fieldName, message);
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST); 
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatch(MethodArgumentTypeMismatchException exception) {

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("message", "Parameter '"+ exception.getName() + "' must be a number");

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}