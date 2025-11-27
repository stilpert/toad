package com.dykyi.lab3.study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
@Entity
@Table(name = "curator")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Curator {
    public Curator(Integer workExperience) {
        this.workExperience = workExperience;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false)
    Long id;
    @Column(name = "work_experience")
    Integer workExperience;
    @OneToOne(mappedBy = "curator")
    Teacher teacher;
    @OneToMany(mappedBy = "curator")
    List<Student>students;
}
