package com.dykyi.toad.automotive.service;

import com.dykyi.toad.automotive.dto.CarDTO;
import com.dykyi.toad.automotive.entity.Car;
import com.dykyi.toad.automotive.enums.OwnerType;
import com.dykyi.toad.automotive.mapper.CarMapper;
import com.dykyi.toad.automotive.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public CarDTO getByNumber(int number) {
        return carMapper.toDTO(carRepository.findByNumber(number).orElseThrow(() -> new RuntimeException("Car doesn't exist")));
    }

    public CarDTO getByIdDto(long id) {
        return carMapper.toDTO(carRepository.findById(id).get());
    }

    public Car getById(long id) {
        return carRepository.findById(id).get();
    }

    public List<CarDTO> getAllByGroup(String group) {
        return carRepository.findAllByGroupOrderByNumberDesc(group).stream().map(carMapper::toDTO).toList();
    }

    public List<CarDTO> getAll() {
        return carRepository.findAll().stream().map(carMapper::toDTO).toList();
    }

    public List<CarDTO> getAllByOwnerType(OwnerType ownerType) {
        return carRepository.findAllByOwnerOwnerType(ownerType).stream().map(carMapper::toDTO).toList();
    }
}
