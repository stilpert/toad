package com.dykyi.toad.study.mapper;

import com.dykyi.toad.study.dto.CourseDTO;
import com.dykyi.toad.study.entity.Course;
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
}
