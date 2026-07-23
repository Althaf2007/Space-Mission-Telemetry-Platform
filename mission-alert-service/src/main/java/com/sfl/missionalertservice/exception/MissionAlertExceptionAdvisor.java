package com.sfl.missionalertservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class MissionAlertExceptionAdvisor {

    @ExceptionHandler(AlertNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAlertException(AlertNotFoundException ex) {

        return ex.getMessage();

    }

}