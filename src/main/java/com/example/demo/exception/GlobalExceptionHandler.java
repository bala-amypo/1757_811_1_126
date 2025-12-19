package com.example.demo.exception;

import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound() {
        return "Requested resource not found";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleValidation(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneric(Exception ex) {
        return "Internal error: " + ex.getMessage();
    }
}
