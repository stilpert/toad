package com.dykyi.lab2.api;

import com.dykyi.lab2.entity.Car;
import com.dykyi.lab2.entity.Student;
import com.dykyi.lab2.enums.Country;
import com.dykyi.lab2.enums.OwnerType;
import com.dykyi.lab2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/")
    public ResponseEntity<List<Car>> getAllCars() {
        try {
            List<Car> cars = carService.getAll();
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        try {
            Car car = carService.getById(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("byGroup/{number}")
    public ResponseEntity<Car> getCarByNumber(@PathVariable Integer number) {
        try {
            Car car = carService.getByNumber(number);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("byGroup/{group}")
    public ResponseEntity<List<Car>> getCarsByGroup(@PathVariable String group) {
        try {
            List<Car> cars = carService.getAllByGroup(group);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byOwnerType/{ownerType}")
    public ResponseEntity<List<Car>> getCarsByOwnerType(@PathVariable
                                                            OwnerType ownerType) {
        try {
            List<Car> cars = carService.getAllByOwnerType(ownerType);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

