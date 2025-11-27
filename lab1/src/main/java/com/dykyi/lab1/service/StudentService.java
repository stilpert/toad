package com.dykyi.lab1.service;

import com.dykyi.lab1.entity.Student;
import com.dykyi.lab1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getByNumber(int number) {
        return studentRepository.findByNumber(number).orElseThrow(() -> new
                RuntimeException("Student doesn't exist"));
    }

    public Student getById(long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllByGroup(String group) {
        return studentRepository.findAllByGroupOrderByNumberDesc(group);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}