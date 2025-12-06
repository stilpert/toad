package com.dykyi.lab13.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.HashSet;
import java.util.Set;

@Node
@Getter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    Long id;
    String title;
    String tagline;
    Integer released;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private Set<ActedIn> actors = new HashSet<>();

    public Movie(String title, String tagline, Integer released) {
        this.title = title;
        this.tagline = tagline;
        this.released = released;
    }
}