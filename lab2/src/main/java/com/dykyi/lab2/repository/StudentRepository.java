package com.dykyi.lab2.repository;

import com.dykyi.lab2.entity.Student;
import com.dykyi.lab2.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNumber(Integer number);

    List<Student> findAllByGroupOrderByNumberDesc(String group);

    List<Student> findAllByAddressCountry(Country country);
}
