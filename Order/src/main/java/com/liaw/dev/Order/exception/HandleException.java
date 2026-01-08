package com.liaw.dev.Order.exception;

import com.liaw.dev.Order.exception.exception.StorageEndException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(StorageEndException.class)
    public ErrorMessage handleStorageEndException(StorageEndException e){
        return new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                e.getMessage()
        );
    }

}
