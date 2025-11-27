package com.dykyi.toad.automotive.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "car_part")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class CarPart {
    public CarPart(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false)
    Long id;

    @Column(name = "part_name")
    String name;

    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;
}

