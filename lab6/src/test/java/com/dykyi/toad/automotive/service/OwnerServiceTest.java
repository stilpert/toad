package com.dykyi.toad.automotive.service;

import com.dykyi.toad.automotive.dto.OwnerDTO;
import com.dykyi.toad.automotive.entity.Owner;
import com.dykyi.toad.automotive.mapper.OwnerMapper;
import com.dykyi.toad.automotive.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceTest {
    @Mock OwnerRepository ownerRepository;
    @Mock OwnerMapper ownerMapper;
    @InjectMocks OwnerService ownerService;

    @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }

    @Test void testSave() {
        Owner owner = new Owner();
        when(ownerRepository.save(owner)).thenReturn(owner);
        assertEquals(owner, ownerService.save(owner));
    }

    @Test void testGetAll() {
        Owner owner = new Owner();
        OwnerDTO dto = new OwnerDTO();
        when(ownerRepository.findAll()).thenReturn(List.of(owner));
        when(ownerMapper.toDTO(owner)).thenReturn(dto);
        List<OwnerDTO> result = ownerService.getAll();
        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
    }

    @Test void testGetById() {
        Owner owner = new Owner();
        OwnerDTO dto = new OwnerDTO();
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));
        when(ownerMapper.toDTO(owner)).thenReturn(dto);
        OwnerDTO result = ownerService.getById(1L);
        assertEquals(dto, result);
    }
}
