package com.dykyi.lab3.study.repository;

import com.dykyi.lab3.study.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
