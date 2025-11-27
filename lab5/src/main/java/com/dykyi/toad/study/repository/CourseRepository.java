package com.dykyi.toad.study.repository;

import com.dykyi.toad.study.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
