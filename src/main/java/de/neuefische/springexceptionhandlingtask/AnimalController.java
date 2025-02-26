package de.neuefische.springexceptionhandlingtask;

import de.neuefische.springexceptionhandlingtask.exception.NoSuchBrandException;
import de.neuefische.springexceptionhandlingtask.exception.NoSuchSpeciesException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @GetMapping("{species}")
    String getAnimalSpecies(@PathVariable String species) {
        if (!species.equals("dog")) {
            throw new NoSuchSpeciesException("Only 'dog' is allowed");
        }
        return species;
    }

    @GetMapping
    String getAllAnimals() {
        throw new NoSuchElementException("No Animals found");
    }
/*
    @ExceptionHandler(NoSuchSpeciesException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNoSuchElementException(NoSuchSpeciesException exception) {
        return new ErrorMessage(exception.getMessage(), LocalDateTime.now());
    }*/
}
