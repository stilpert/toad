package com.dykyi.toad.automotive.mapper;

import com.dykyi.toad.automotive.dto.CarDTO;
import com.dykyi.toad.automotive.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarMapper {
    private final OwnerMapper ownerMapper;
    private final CarPartMapper carPartMapper;

    public CarDTO toDTO(Car car) {
        if (car == null) return null;
        return new CarDTO(
            car.getId(),
            car.getModel(),
            ownerMapper.toDTO(car.getOwner()),
            car.getCarParts() != null ? car.getCarParts().stream().map(carPartMapper::toDTO).collect(Collectors.toList()) : null
        );
    }

    public Car fromDTO(CarDTO dto) {
        if (dto == null) return null;
        Car car = new Car();
        car.setId(dto.getId());
        car.setModel(dto.getModel());
        car.setOwner(ownerMapper.fromDTO(dto.getOwner()));
        if (dto.getParts() != null) {
            car.setCarParts(dto.getParts().stream().map(carPartMapper::fromDTO).collect(java.util.stream.Collectors.toList()));
        }
        return car;
    }
}
