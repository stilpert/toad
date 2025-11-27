package com.dykyi.lab3.study.repository;

import com.dykyi.lab3.study.entity.Student;
import com.dykyi.lab3.study.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNumber(Integer number);

    List<Student> findAllByGroupOrderByNumberDesc(String group);

    List<Student> findAllByAddressCountry(Country country);
}
