package com.testtask.controller.exhandler;

import com.testtask.exception.file.ImageLoadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ImageLoadException.class)
    protected ResponseEntity<String> handleFileException(ImageLoadException ex) {
        return new ResponseEntity<>("error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
