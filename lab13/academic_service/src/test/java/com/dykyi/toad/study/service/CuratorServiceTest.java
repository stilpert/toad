package com.dykyi.toad.service;

import com.dykyi.toad.entity.Curator;
import com.dykyi.toad.entity.Teacher;
import com.dykyi.toad.repository.CuratorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuratorServiceTest {
    @Mock CuratorRepository curatorRepository;
    @InjectMocks CuratorService curatorService;

    @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }

    @Test void testSave() {
        Curator curator = new Curator();
        when(curatorRepository.save(curator)).thenReturn(curator);
        assertEquals(curator, curatorService.save(curator));
    }

    @Test void testGetNameById() {
        Curator curator = mock(Curator.class);
        Teacher teacher = mock(Teacher.class);
        when(curatorRepository.findById(1L)).thenReturn(Optional.of(curator));
        when(curator.getTeacher()).thenReturn(teacher);
        when(teacher.getName()).thenReturn("John Doe");
        assertEquals("John Doe", curatorService.getNameById(1L));
    }

    @Test void testGetNameByIdNotFound() {
        when(curatorRepository.findById(2L)).thenReturn(Optional.empty());
        Exception ex = assertThrows(RuntimeException.class, () -> curatorService.getNameById(2L));
        assertTrue(ex.getMessage().contains("Curator doesn't exist"));
    }
}

