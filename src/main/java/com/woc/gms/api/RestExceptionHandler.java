package com.woc.gms.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<?> handleException(RuntimeException e){
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", e.getMessage());
        ResponseEntity<Map<String, String>> errorResponse = new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        return errorResponse;
    }
}
