package com.dykyi.lab1.repository;

import com.dykyi.lab1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNumber(Integer number);

    List<Student> findAllByGroupOrderByNumberDesc(String group);
}
