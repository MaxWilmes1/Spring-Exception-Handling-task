package de.neuefische.springexceptionhandlingtask;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public record ErrorMessage (
        String message,
        String exceptionType,
        LocalDateTime timestamp
) {
}
