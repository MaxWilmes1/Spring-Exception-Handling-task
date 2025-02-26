package de.neuefische.springexceptionhandlingtask.exception;

import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
public class OnlyPorscheAllowedException extends IllegalArgumentException {

    public final String errorType;

    public OnlyPorscheAllowedException(String message) {
        super(message);
        this.errorType = "OnlyPorscheAllowedException";
    }

}
