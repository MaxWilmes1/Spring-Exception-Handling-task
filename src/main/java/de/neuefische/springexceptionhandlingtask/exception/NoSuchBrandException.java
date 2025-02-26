package de.neuefische.springexceptionhandlingtask.exception;

import java.util.NoSuchElementException;

public class NoSuchBrandException extends NoSuchElementException {

    public NoSuchBrandException(String message) {
        super(message);
    }
}
