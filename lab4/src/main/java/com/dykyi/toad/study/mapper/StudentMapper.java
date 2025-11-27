package com.dykyi.toad.study.mapper;

import com.dykyi.toad.study.dto.StudentDTO;
import com.dykyi.toad.study.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    private final CuratorMapper curatorMapper;
    private final CourseMapper courseMapper;

    public StudentDTO toDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getBirthDate(),
                student.getGroup(),
                student.getNumber(),
                student.getAddress(),
                curatorMapper.toDTO(student.getCurator()),
                student.getFinishedCourses().stream().map(item -> courseMapper.toDTO(item)).collect(Collectors.toList())
        );
    }
}
