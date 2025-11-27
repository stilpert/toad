package com.dykyi.lab1.repository;

import com.dykyi.lab1.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByNumber(Integer number);
    List<Car> findAllByGroupOrderByNumberDesc(String group);
}

