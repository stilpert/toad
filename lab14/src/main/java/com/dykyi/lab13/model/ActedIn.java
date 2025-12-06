package com.dykyi.lab13.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import java.util.List;
@RelationshipProperties
@Getter
@Setter
@NoArgsConstructor
public class ActedIn {
    @Id
    @GeneratedValue
    private Long id;
    private List<String> roles;
    @TargetNode
    private Movie movie;
}