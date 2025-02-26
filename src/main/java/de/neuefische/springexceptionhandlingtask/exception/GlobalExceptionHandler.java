package de.neuefische.springexceptionhandlingtask.exception;

import de.neuefische.springexceptionhandlingtask.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(NoSuchSpeciesException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNoSuchSpeciesException(NoSuchSpeciesException exception) {
        return new ErrorMessage(exception.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(NoSuchBrandException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNoSuchBrandException(NoSuchBrandException exception) {
        return new ErrorMessage(exception.getMessage(), LocalDateTime.now());
    }
}
