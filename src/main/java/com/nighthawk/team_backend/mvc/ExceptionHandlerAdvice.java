package com.nighthawk.team_backend.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    
    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity jsonProcessingException(JsonProcessingException e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("JSON failed to process");
    } 
    
    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity jsonMappingException(JsonMappingException e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("JSON failed to map");
    }
}
