package com.example.backendspringboottechiteasycontrollerles10.controllers;

import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.TelevisionNameTooLongException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public ResponseEntity<String> exception (RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> exception (IndexOutOfBoundsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> exception (TelevisionNameTooLongException exception) {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

    /*TODO maak exceptionHandlers voor de 2 nieuwe exceptions*/
}
