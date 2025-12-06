package com.dykyi.toad.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Document("course")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Course {
    public Course(String name, Double credits) {
        this.name = name;
        this.credits = credits;
    }
    @Id
    String id;
    String name;
    Double credits;
    List<Student> finishedStudents;
}