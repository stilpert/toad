package com.dykyi.toad.study.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.util.Calendar;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "teacher")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Teacher {
    static final long serialVersionUID = 1L;

    public Teacher(String name, Address address, Calendar birthDate) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false)
    Long id;

    @Column(name = "teacher_name")
    String name;

    @Embedded
    Address address;

    @Column(name = "birth_date", updatable = false)
    Calendar birthDate;

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curator_id", referencedColumnName = "id")
    Curator curator;
}

