package com.liaw.dev.User.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorMessage handleUserNotFoundException(UserNotFoundException e){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailExistingException.class)
    public ErrorMessage handleEmailExistingException(EmailExistingException e){
        return new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                e.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
        );
    }

}
