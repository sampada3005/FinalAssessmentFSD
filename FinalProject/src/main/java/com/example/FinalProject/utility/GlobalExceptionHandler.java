package com.example.FinalProject.utility;


import com.example.FinalProject.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleCustomerNotFound(EntityNotFoundException customerNotFoundException){
       Map<String, Object> response = new HashMap<>();
       response.put("message", customerNotFoundException.getMessage());

       return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
