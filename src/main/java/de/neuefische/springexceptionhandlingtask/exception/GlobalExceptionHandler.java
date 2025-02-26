package de.neuefische.springexceptionhandlingtask.exception;

import de.neuefische.springexceptionhandlingtask.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNoSuchElementException(NoSuchElementException exception) {
        return new ErrorMessage(exception.getMessage(), "NoSuchElementException", LocalDateTime.now());
    }

    // Allgemeine Behandlung für alle anderen Ausnahmen
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleGenericException(Exception exception) {
        return new ErrorMessage(exception.getMessage(), exception.getClass().getSimpleName(), LocalDateTime.now());
    }
}
