package com.dykyi.lab1.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "car")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Car {
    public Car(String model, Integer year, String group, Integer number) {
        this.model = model;
        this.year = year;
        this.group = group;
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false)
    Long id;
    @Column(name = "car_model")
    String model;
    @Column(name = "car_year", updatable = false)
    Integer year;
    @Column(name = "car_group")
    String group;
    @Column(updatable = false, unique = true)
    Integer number;
}