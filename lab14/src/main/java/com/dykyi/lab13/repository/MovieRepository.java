package com.dykyi.lab13.repository;

import com.dykyi.lab13.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    List<Movie> findByReleased(int released);
}