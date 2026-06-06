package com.demo.first.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// @ControllerAdvice ---> works with all a generalized annotation
@RestControllerAdvice //global handler exceptions --> centralized(return JSON)

public class GlobalExceptionHandler {
    //creatting exception handling method
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class}) //only works with IllegalArgumentException & NullPointerException
    public ResponseEntity<Map<String , Object>> handleIllegalArgumentException(Exception exception){
        Map<String , Object> errorResponse = new HashMap<>();
        errorResponse.put("timeStamp" , LocalDateTime.now());
        errorResponse.put("status" , HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error" , "BadRequest");
        errorResponse.put("message" , exception.getMessage());
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String , Object>> MethodNotSupported(Exception exception){
        Map<String , Object> errorResponse = new HashMap<>();
        errorResponse.put("timeStamp" , LocalDateTime.now());
        errorResponse.put("status" , HttpStatus.METHOD_NOT_ALLOWED.value());
        errorResponse.put("error" , "method not allowed");
        errorResponse.put("message" , exception.getMessage());
        return new ResponseEntity<>(errorResponse , HttpStatus.METHOD_NOT_ALLOWED);
    }
}
