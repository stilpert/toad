package com.dykyi.lab3.automotive.service;

import com.dykyi.lab3.automotive.entity.CarPart;
import com.dykyi.lab3.automotive.repository.CarPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarPartService {
    private final CarPartRepository carPartRepository;

    public List<CarPart> findAll() {
        return carPartRepository.findAll();
    }

    public Optional<CarPart> findById(Long id) {
        return carPartRepository.findById(id);
    }

    public CarPart save(CarPart carPart) {
        return carPartRepository.save(carPart);
    }

    public void deleteById(Long id) {
        carPartRepository.deleteById(id);
    }
}

