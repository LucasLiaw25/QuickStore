package exceptions;

import exceptions.exception.StorageEndException;
import exceptions.exception.StorageNotFoundException;
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StorageNotFoundException.class)
    public ErrorMessage handleStorageNotFoundException(StorageNotFoundException e){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
    }

}
