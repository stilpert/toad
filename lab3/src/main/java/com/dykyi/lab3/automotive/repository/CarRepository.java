package com.dykyi.lab3.automotive.repository;

import com.dykyi.lab3.automotive.entity.Car;
import com.dykyi.lab3.automotive.enums.OwnerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByNumber(Integer number);
    List<Car> findAllByGroupOrderByNumberDesc(String group);
    List<Car> findAllByOwnerOwnerType(OwnerType ownerType);
}

