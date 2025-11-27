package com.dykyi.toad.service;

import com.dykyi.toad.entity.Teacher;
import com.dykyi.toad.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class TeacherServiceTest {
    @Mock TeacherRepository teacherRepository;
    @InjectMocks TeacherService teacherService;

    @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }

    @Test void testSave() {
        Teacher teacher = new Teacher();
        when(teacherRepository.save(teacher)).thenReturn(teacher);
        assertEquals(teacher, teacherService.save(teacher));
    }
}


