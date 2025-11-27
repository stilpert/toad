package com.dykyi.lab3.automotive.api;

import com.dykyi.lab3.automotive.entity.Car;
import com.dykyi.lab3.automotive.entity.CarPart;
import com.dykyi.lab3.automotive.enums.OwnerType;
import com.dykyi.lab3.automotive.service.CarPartService;
import com.dykyi.lab3.automotive.service.CarService;
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
    private final CarPartService carPartService;

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

    @GetMapping("/{carId}/parts")
    public ResponseEntity<List<CarPart>> getCarParts(@PathVariable Long carId) {
        try {
            Car car = carService.getById(carId);
            return new ResponseEntity<>(car.getCarParts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{carId}/parts")
    public ResponseEntity<CarPart> addCarPart(@PathVariable Long carId, @RequestBody CarPart carPart) {
        try {
            Car car = carService.getById(carId);
            CarPart newPart = new CarPart(carPart.getName(), car);
            CarPart saved = carPartService.save(newPart);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parts/{partId}")
    public ResponseEntity<CarPart> getCarPart(@PathVariable Long partId) {
        try {
            return carPartService.findById(partId)
                .map(part -> new ResponseEntity<>(part, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/parts/{partId}")
    public ResponseEntity<CarPart> updateCarPart(@PathVariable Long partId, @RequestBody CarPart carPart) {
        try {
            return carPartService.findById(partId)
                .map(existing -> {
                    existing = new CarPart(carPart.getName(), existing.getCar());
                    CarPart updated = carPartService.save(existing);
                    return new ResponseEntity<>(updated, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/parts/{partId}")
    public ResponseEntity<Void> deleteCarPart(@PathVariable Long partId) {
        try {
            carPartService.deleteById(partId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
