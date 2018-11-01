package com.nynjaorca.orcablog.orcablog.security;

import com.nynjaorca.orcablog.orcablog.exceptions.AnimalIdMismatchException;
import com.nynjaorca.orcablog.orcablog.exceptions.AnimalNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({ AnimalNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Animal not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ AnimalIdMismatchException.class, ConstraintViolationException.class, DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}