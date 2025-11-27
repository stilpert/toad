package com.dykyi.toad.repository;

import com.dykyi.toad.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
