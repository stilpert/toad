package com.dykyi.toad.study.repository;

import com.dykyi.toad.study.entity.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepository extends JpaRepository<Curator, Long> {
}
