package com.viacept.projeto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception exception){
        HashMap<String, Object> erroTempo = new HashMap<>();
        erroTempo.put("Timestamp", LocalDateTime.now());
        return new ResponseEntity<>(erroTempo, HttpStatus.I_AM_A_TEAPOT);
    }
}
