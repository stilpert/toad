package com.dykyi.lab3.study.repository;

import com.dykyi.lab3.study.entity.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepository extends JpaRepository<Curator, Long> {
}
