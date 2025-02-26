package de.neuefische.springexceptionhandlingtask.exception;

import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
public class OnlyDogAllowedException extends IllegalArgumentException {

    private final String errorType;

    public OnlyDogAllowedException(String message) {
        super(message);
        this.errorType = "OnlyDogAllowedException";
    }

}
