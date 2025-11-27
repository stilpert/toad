package com.dykyi.toad.repository;

import com.dykyi.toad.entity.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepository extends JpaRepository<Curator, Long> {
}
