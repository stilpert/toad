package com.dykyi.toad.study.service;

import com.dykyi.toad.study.entity.Course;
import com.dykyi.toad.study.entity.Student;
import com.dykyi.toad.study.repository.CourseRepository;
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