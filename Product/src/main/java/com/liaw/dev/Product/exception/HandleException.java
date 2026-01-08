package com.liaw.dev.Product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorMessage handleProductNotFoundException(ProductNotFoundException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
        );
    }

}
