package de.neuefische.springexceptionhandlingtask;

import java.time.LocalDateTime;

public record ErrorMessage (
        String message,
        String exceptionType,
        LocalDateTime timestamp
) {
}
