package com.dykyi.toad.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "student")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Student {
    static final long serialVersionUID = 1L;

    public Student(String name, Calendar birthDate, String group, Integer number, Address addres) {
        this.name = name;
        this.birthDate = birthDate;
        this.group = group;
        this.number = number;
        this.address = addres;
        this.finishedCourses=new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false)
    Long id;
    @Column(name = "student_name")
    String name;
    @Column(name = "birth_date", updatable = false)
    Calendar birthDate;
    @Column(name = "student_group")
    String group;
    @Column(updatable = false, unique = true)
    Integer number;
    @Embedded
    Address address;

    @Setter
    @ManyToOne
    @JoinColumn(name="curator_id")
    private Curator curator;

    @ManyToMany
    @JoinTable(
            name = "finish_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> finishedCourses;

    public void addCourse(Course course){
        finishedCourses.add(course);
    }

}