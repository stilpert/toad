package com.dykyi.toad.automotive.service;

import com.dykyi.toad.automotive.dto.CarPartDTO;
import com.dykyi.toad.automotive.entity.CarPart;
import com.dykyi.toad.automotive.mapper.CarPartMapper;
import com.dykyi.toad.automotive.repository.CarPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarPartService {
    private final CarPartRepository carPartRepository;
    private final CarPartMapper carPartMapper;

    public List<CarPartDTO> findAll() {
        return carPartRepository.findAll().stream().map(carPartMapper::toDTO).toList();
    }

    public Optional<CarPartDTO> findById(Long id) {
        return carPartRepository.findById(id).map(carPartMapper::toDTO);
    }

    public CarPartDTO save(CarPart carPart) {
        return carPartMapper.toDTO(carPartRepository.save(carPart));
    }

    public void deleteById(Long id) {
        carPartRepository.deleteById(id);
    }
}
