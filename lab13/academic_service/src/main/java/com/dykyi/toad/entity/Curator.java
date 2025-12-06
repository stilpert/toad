package com.dykyi.toad.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Document("curator")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Curator {
    public Curator(Integer workExperience) {
        this.workExperience = workExperience;
    }

    @Id
    String id;
    Integer workExperience;
    Teacher teacher;
    List<Student> students;
}
