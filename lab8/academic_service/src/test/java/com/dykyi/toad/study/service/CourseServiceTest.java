package com.dykyi.toad.service;

import com.dykyi.toad.dto.CourseDTO;
import com.dykyi.toad.entity.Course;
import com.dykyi.toad.entity.Student;
import com.dykyi.toad.mapper.CourseMapper;
import com.dykyi.toad.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceTest {
    @Mock CourseRepository courseRepository;
    @Mock CourseMapper courseMapper;
    @InjectMocks CourseService courseService;

    @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }

    @Test void testSaveEntity() {
        Course course = new Course();
        when(courseRepository.save(course)).thenReturn(course);
        assertEquals(course, courseService.save(course));
    }

    @Test void testGetStudentsByCourseId() {
        Course course = mock(Course.class);
        List<Student> students = List.of(new Student());
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(course.getFinishedStudents()).thenReturn(students);
        assertEquals(students, courseService.getStudentsByCourseId(1L));
    }

    @Test void testGetStudentsByCourseIdNotFound() {
        when(courseRepository.findById(2L)).thenReturn(Optional.empty());
        Exception ex = assertThrows(RuntimeException.class, () -> courseService.getStudentsByCourseId(2L));
        assertTrue(ex.getMessage().contains("Course doesn't exist"));
    }

    @Test void testSaveDTO() {
        CourseDTO dto = new CourseDTO();
        Course course = new Course();
        when(courseMapper.toEntity(dto)).thenReturn(course);
        when(courseRepository.save(course)).thenReturn(course);
        when(courseMapper.toDTO(course)).thenReturn(dto);
        assertEquals(dto, courseService.save(dto));
    }

    @Test void testGetAll() {
        Course course = new Course();
        CourseDTO dto = new CourseDTO();
        when(courseRepository.findAll()).thenReturn(List.of(course));
        when(courseMapper.toDTO(course)).thenReturn(dto);
        List<CourseDTO> result = courseService.getAll();
        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
    }
}