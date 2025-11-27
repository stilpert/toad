package com.toad.dykyi.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "certificate")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Certificate {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false)
    Long id;
    @Column(name = "student_name", updatable = false)
    String studentName;
    @Column(name = "course_name", updatable = false)
    String courseName;
    @Column(name = "credits")
    Double credits;
    @Column(name = "code", unique = true, updatable = false)
    String code;

    public Certificate(String studentName, String courseName, Double credits,
                       String code) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.credits = credits;
        this.code = code;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }
}