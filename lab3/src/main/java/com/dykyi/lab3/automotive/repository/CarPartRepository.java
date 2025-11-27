package com.dykyi.lab3.automotive.repository;

import com.dykyi.lab3.automotive.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}