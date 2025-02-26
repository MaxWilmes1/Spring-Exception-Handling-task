package de.neuefische.springexceptionhandlingtask;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public record ErrorMessage (
        String message,
        LocalDateTime timestamp
) {
}
