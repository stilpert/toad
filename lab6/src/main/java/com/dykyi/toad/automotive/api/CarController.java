package com.dykyi.toad.automotive.api;

import com.dykyi.toad.automotive.dto.CarDTO;
import com.dykyi.toad.automotive.dto.CarPartDTO;
import com.dykyi.toad.automotive.entity.Car;
import com.dykyi.toad.automotive.entity.CarPart;
import com.dykyi.toad.automotive.enums.OwnerType;
import com.dykyi.toad.automotive.mapper.CarMapper;
import com.dykyi.toad.automotive.mapper.CarPartMapper;
import com.dykyi.toad.automotive.service.CarPartService;
import com.dykyi.toad.automotive.service.CarService;
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
    private final CarPartMapper carPartMapper;
    private final CarMapper carMapper;

    @GetMapping("/")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        try {
            List<CarDTO> cars = carService.getAll();
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
        try {
            CarDTO car = carService.getByIdDto(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("byGroup/{number}")
    public ResponseEntity<CarDTO> getCarByNumber(@PathVariable Integer number) {
        try {
            CarDTO car = carService.getByNumber(number);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("byGroup/{group}")
    public ResponseEntity<List<CarDTO>> getCarsByGroup(@PathVariable String group) {
        try {
            List<CarDTO> cars = carService.getAllByGroup(group);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byOwnerType/{ownerType}")
    public ResponseEntity<List<CarDTO>> getCarsByOwnerType(@PathVariable
                                                            OwnerType ownerType) {
        try {
            List<CarDTO> cars = carService.getAllByOwnerType(ownerType);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{carId}/parts")
    public ResponseEntity<List<CarPartDTO>> getCarParts(@PathVariable Long carId) {
        try {
            CarDTO car = carService.getByIdDto(carId);
            return new ResponseEntity<>(car.getParts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{carId}/parts")
    public ResponseEntity<CarPartDTO> addCarPart(@PathVariable Long carId, @RequestBody CarPart carPart) {
        try {
            Car car = carService.getById(carId);
            CarPart newPart = new CarPart(carPart.getName(), car);
            CarPartDTO saved = carPartService.save(newPart);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parts/{partId}")
    public ResponseEntity<CarPartDTO> getCarPart(@PathVariable Long partId) {
        try {
            return carPartService.findById(partId)
                .map(part -> new ResponseEntity<>(part, HttpStatus.OK))
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

    @PostMapping("")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
        try {
            Car car = carMapper.fromDTO(carDTO);
            Car savedCar = carService.save(car);
            return new ResponseEntity<>(carMapper.toDTO(savedCar), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        try {
            Car existingCar = carService.getById(id);
            Car updatedCar = carMapper.fromDTO(carDTO);
            updatedCar.setId(id); // ensure correct id
            Car savedCar = carService.save(updatedCar);
            return new ResponseEntity<>(carMapper.toDTO(savedCar), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/parts")
    public ResponseEntity<CarPartDTO> createCarPart(@RequestBody CarPartDTO carPartDTO) {
        try {
            CarPart carPart = carPartMapper.fromDTO(carPartDTO);
            CarPartDTO saved = carPartService.save(carPart);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/parts/{partId}")
    public ResponseEntity<CarPartDTO> updateCarPart(@PathVariable Long partId, @RequestBody CarPartDTO carPartDTO) {
        try {
            CarPart carPart = carPartMapper.fromDTO(carPartDTO);
            carPart.setId(partId);
            CarPartDTO saved = carPartService.save(carPart);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
