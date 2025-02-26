package de.neuefische.springexceptionhandlingtask;

import de.neuefische.springexceptionhandlingtask.exception.NoSuchBrandException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping("{brand}")
    String getCarBrand(@PathVariable String brand) {
        if (!brand.equals("porsche")) {
            throw new NoSuchBrandException("Only 'porsche' allowed");
        }
        return brand;
    }

    @GetMapping
    String getAllCars() {
        throw new NoSuchElementException("No Cars found");
    }

/*    @ExceptionHandler(NoSuchBrandException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNoSuchElementException(NoSuchBrandException exception) {
        return new ErrorMessage(exception.getMessage(), LocalDateTime.now());
    }*/
}
