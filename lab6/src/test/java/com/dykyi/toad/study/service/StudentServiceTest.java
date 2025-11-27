package com.dykyi.toad.study.service;

import com.dykyi.toad.study.dto.StudentDTO;
import com.dykyi.toad.study.entity.Curator;
import com.dykyi.toad.study.entity.Student;
import com.dykyi.toad.study.mapper.StudentMapper;
import com.dykyi.toad.study.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    @Mock StudentRepository studentRepository;
    @Mock StudentMapper studentMapper;
    @InjectMocks StudentService studentService;

    @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }

    @Test void testSave() {
        Student student = new Student();
        when(studentRepository.save(student)).thenReturn(student);
        assertEquals(student, studentService.save(student));
    }

    @Test void testGetById() {
        Student student = new Student();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        assertEquals(student, studentService.getById(1L));
    }

    @Test void testGetAll() {
        Student student = new Student();
        when(studentRepository.findAll()).thenReturn(List.of(student));
        List<Student> result = studentService.getAll();
        assertEquals(1, result.size());
        assertEquals(student, result.get(0));
    }

    @Test void testGetCuratorNameWithoutCurator() {
        Student student = mock(Student.class);
        when(studentRepository.findById(2L)).thenReturn(Optional.of(student));
        when(student.getCurator()).thenReturn(null);
        assertEquals("This student doesn't have a curator", studentService.getCuratorName(2L));
    }

    @Test void testGetCuratorNameNotFound() {
        when(studentRepository.findById(3L)).thenReturn(Optional.empty());
        Exception ex = assertThrows(RuntimeException.class, () -> studentService.getCuratorName(3L));
        assertTrue(ex.getMessage().contains("Student doesn't exist"));
    }
}

