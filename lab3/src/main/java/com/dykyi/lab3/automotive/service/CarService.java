package com.dykyi.lab3.automotive.service;

import com.dykyi.lab3.automotive.entity.Car;
import com.dykyi.lab3.automotive.enums.OwnerType;
import com.dykyi.lab3.automotive.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car getByNumber(int number) {
        return carRepository.findByNumber(number).orElseThrow(() -> new RuntimeException("Car doesn't exist"));
    }

    public Car getById(long id) {
        return carRepository.findById(id).get();
    }

    public List<Car> getAllByGroup(String group) {
        return carRepository.findAllByGroupOrderByNumberDesc(group);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public List<Car> getAllByOwnerType(OwnerType ownerType) {
        return carRepository.findAllByOwnerOwnerType(ownerType);
    }
}

