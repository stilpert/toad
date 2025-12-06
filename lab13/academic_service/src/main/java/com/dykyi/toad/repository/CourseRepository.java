package com.dykyi.toad.repository;

import com.dykyi.toad.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
