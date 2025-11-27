package com.dykyi.toad.automotive.service;

import com.dykyi.toad.automotive.dto.CarPartDTO;
import com.dykyi.toad.automotive.entity.CarPart;
import com.dykyi.toad.automotive.mapper.CarPartMapper;
import com.dykyi.toad.automotive.repository.CarPartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarPartServiceTest {
    @Mock CarPartRepository carPartRepository;
    @Mock CarPartMapper carPartMapper;
    @InjectMocks CarPartService carPartService;

    @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }

    @Test void testFindAll() {
        CarPart part = new CarPart();
        CarPartDTO dto = new CarPartDTO();
        when(carPartRepository.findAll()).thenReturn(List.of(part));
        when(carPartMapper.toDTO(part)).thenReturn(dto);
        List<CarPartDTO> result = carPartService.findAll();
        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
    }

    @Test void testFindById() {
        CarPart part = new CarPart();
        CarPartDTO dto = new CarPartDTO();
        when(carPartRepository.findById(1L)).thenReturn(Optional.of(part));
        when(carPartMapper.toDTO(part)).thenReturn(dto);
        Optional<CarPartDTO> result = carPartService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(dto, result.get());
    }

    @Test void testSave() {
        CarPart part = new CarPart();
        CarPartDTO dto = new CarPartDTO();
        when(carPartRepository.save(part)).thenReturn(part);
        when(carPartMapper.toDTO(part)).thenReturn(dto);
        CarPartDTO result = carPartService.save(part);
        assertEquals(dto, result);
    }

    @Test void testDeleteById() {
        carPartService.deleteById(1L);
        verify(carPartRepository, times(1)).deleteById(1L);
    }
}

