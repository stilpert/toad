package com.dykyi.toad.automotive.repository;

import com.dykyi.toad.automotive.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}