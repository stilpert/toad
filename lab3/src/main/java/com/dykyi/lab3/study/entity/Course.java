package com.dykyi.lab3.study.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
@Entity
@Table(name = "course")
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false)
    Long id;
    @Column(name="course_name")
    String name;
    @Column(name = "credits")
    Double credits;

    @ManyToMany(mappedBy = "finishedCourses")
    List<Student> finishedStudents;
}