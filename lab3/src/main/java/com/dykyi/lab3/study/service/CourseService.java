package com.dykyi.lab3.study.service;

import com.dykyi.lab3.study.entity.Course;
import com.dykyi.lab3.study.entity.Student;
import com.dykyi.lab3.study.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public List<Student> getStudentsByCourseId(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return course.get().getFinishedStudents();
        } else {
            throw new RuntimeException("Course doesn't exist, id=" + courseId);
        }
    }
}