package com.dykyi.lab3.study.service;

import com.dykyi.lab3.study.entity.Teacher;
import com.dykyi.lab3.study.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}