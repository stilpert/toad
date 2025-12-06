package com.dykyi.toad.mapper;

import com.dykyi.toad.dto.CourseDTO;
import com.dykyi.toad.entity.Course;
import org.springframework.stereotype.Component;
@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course){
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getCredits()
        );
    }
    public Course toEntity(CourseDTO courseDTO){
        return new Course(
                courseDTO.getName(),
                courseDTO.getCredits()
        );
    }
}
