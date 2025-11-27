package com.dykyi.lab3.automotive.repository;

import com.dykyi.lab3.automotive.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

