package com.dykyi.lab2.repository;

import com.dykyi.lab2.entity.Car;
import com.dykyi.lab2.enums.OwnerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByNumber(Integer number);
    List<Car> findAllByGroupOrderByNumberDesc(String group);
    List<Car> findAllByOwnerOwnerType(OwnerType ownerType);
}

