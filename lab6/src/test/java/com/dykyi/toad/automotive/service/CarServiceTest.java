package com.dykyi.toad.automotive.service;

import com.dykyi.toad.automotive.dto.CarDTO;
import com.dykyi.toad.automotive.entity.Car;
import com.dykyi.toad.automotive.enums.OwnerType;
import com.dykyi.toad.automotive.mapper.CarMapper;
import com.dykyi.toad.automotive.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {
    @Mock CarRepository carRepository;
    @Mock CarMapper carMapper;
    @InjectMocks CarService carService;

    @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }

    @Test void testSave() {
        Car car = new Car();
        when(carRepository.save(car)).thenReturn(car);
        assertEquals(car, carService.save(car));
    }

    @Test void testGetByNumber() {
        Car car = new Car();
        CarDTO dto = new CarDTO();
        when(carRepository.findByNumber(1)).thenReturn(Optional.of(car));
        when(carMapper.toDTO(car)).thenReturn(dto);
        assertEquals(dto, carService.getByNumber(1));
    }

    @Test void testGetByIdDto() {
        Car car = new Car();
        CarDTO dto = new CarDTO();
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carMapper.toDTO(car)).thenReturn(dto);
        assertEquals(dto, carService.getByIdDto(1L));
    }

    @Test void testGetById() {
        Car car = new Car();
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        assertEquals(car, carService.getById(1L));
    }

    @Test void testGetAllByGroup() {
        Car car = new Car();
        CarDTO dto = new CarDTO();
        when(carRepository.findAllByGroupOrderByNumberDesc("group")).thenReturn(List.of(car));
        when(carMapper.toDTO(car)).thenReturn(dto);
        List<CarDTO> result = carService.getAllByGroup("group");
        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
    }

    @Test void testGetAll() {
        Car car = new Car();
        CarDTO dto = new CarDTO();
        when(carRepository.findAll()).thenReturn(List.of(car));
        when(carMapper.toDTO(car)).thenReturn(dto);
        List<CarDTO> result = carService.getAll();
        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
    }

    @Test void testGetAllByOwnerType() {
        Car car = new Car();
        CarDTO dto = new CarDTO();
        when(carRepository.findAllByOwnerOwnerType(OwnerType.INDIVIDUAL)).thenReturn(List.of(car));
        when(carMapper.toDTO(car)).thenReturn(dto);
        List<CarDTO> result = carService.getAllByOwnerType(OwnerType.INDIVIDUAL);
        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
    }
}
