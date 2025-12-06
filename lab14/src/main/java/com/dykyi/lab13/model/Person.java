package com.dykyi.lab13.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
@Getter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    Long id;
    Integer born;
    String name;

    @Relationship(type = "ACTED_IN")
    private Set<ActedIn> actedInMovies = new HashSet<>();

    public Person(Integer born, String name) {
        this.born = born;
        this.name = name;
    }
}
