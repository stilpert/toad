package com.dykyi.toad.service;

import com.dykyi.toad.dto.CourseDTO;
import com.dykyi.toad.entity.Course;
import com.dykyi.toad.entity.Student;
import com.dykyi.toad.mapper.CourseMapper;
import com.dykyi.toad.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public List<Student> getStudentsByCourseId(String courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return course.get().getFinishedStudents();
        } else {
            throw new RuntimeException("Course doesn't exist, id=" + courseId);
        }
    }

    public CourseDTO save(CourseDTO courseDTO){
        Course course = courseMapper.toEntity(courseDTO);
        return courseMapper.toDTO(save(course));
    }

    public List<CourseDTO> getAll(){
        return courseRepository
                .findAll()
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }
}