package de.neuefische.springexceptionhandlingtask.exception;

import java.util.NoSuchElementException;

public class NoSuchSpeciesException extends NoSuchElementException {

    public NoSuchSpeciesException(String message) {
        super(message);
    }
}
