package com.dykyi.toad.service;

import com.dykyi.toad.entity.Teacher;
import com.dykyi.toad.repository.TeacherRepository;
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