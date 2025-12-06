package com.dykyi.toad.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Document("student")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Student {
    public Student(String name, Calendar birthDate, String group, Integer number, Address addres) {
        this.name = name;
        this.birthDate = birthDate.getTime().toString();
        this.group = group;
        this.number = number;
        this.address = addres;
        this.finishedCourses = new ArrayList<>();
    }

    @Id
    String id;
    String name;
    String birthDate;
    String group;
    Integer number;
    Address address;
    @Setter
    private Curator curator;
    List<Course> finishedCourses;

    public void addCourse(Course course) {
        finishedCourses.add(course);
    }

}