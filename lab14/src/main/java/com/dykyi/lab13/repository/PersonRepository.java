package com.dykyi.lab13.repository;

import com.dykyi.lab13.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
    Optional<Person> findByName(String name);
}