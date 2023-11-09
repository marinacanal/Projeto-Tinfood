<<<<<<< HEAD:registration-login-springboot-security-thymeleaf-master/src/main/java/com/example/registrationlogindemo/controller/GlobalExceptionHandler.java
package com.example.registrationlogindemo.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.registrationlogindemo.validation.PaginaNaoEncontrada;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>("Ocorreu um erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleGlobalException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("Existem dependências", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(EntityNotFoundException ex) {
        return new ResponseEntity<>("Código não encotrado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaginaNaoEncontrada.class)
    public ResponseEntity<String> handleResourceNotFoundException(PaginaNaoEncontrada ex) {
        return new ResponseEntity<>("Página não encontrada", HttpStatus.NOT_FOUND);
    }
}
=======
package com.example.registrationlogindemo.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.registrationlogindemo.validation.PaginaNaoEncontrada;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>("Ocorreu um erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleGlobalException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("Existem dependências", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(EntityNotFoundException ex) {
        return new ResponseEntity<>("Código não encotrado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaginaNaoEncontrada.class)
    public ResponseEntity<String> handleResourceNotFoundException(PaginaNaoEncontrada ex) {
        return new ResponseEntity<>("Página não encontrada", HttpStatus.NOT_FOUND);
    }
}
>>>>>>> f37bb475635418cda0b692a6fafa54d7437f1511:registration-login-springboot-security-thymeleaf-master (3)/registration-login-springboot-security-thymeleaf-master/src/main/java/com/example/registrationlogindemo/controller/GlobalExceptionHandler.java
