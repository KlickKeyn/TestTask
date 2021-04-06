package com.testtask.controller.exhandler;

import com.testtask.exception.file.ImageLoadException;
import com.testtask.exception.statistics.StatisticsException;
import com.testtask.exception.user.UserException;
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

    @ExceptionHandler(UserException.class)
    protected ResponseEntity<String> handleUserException(UserException ex) {
        return new ResponseEntity<>("error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StatisticsException.class)
    protected ResponseEntity<String> handleStatisticsException(StatisticsException ex) {
        return new ResponseEntity<>("error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
