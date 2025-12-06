package com.dykyi.toad.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Calendar;

import static lombok.AccessLevel.PRIVATE;

@Document("teacher")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = PRIVATE)
public class Teacher {

    public Teacher(String name, Address address, Calendar birthDate) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate.getTime().toString();
    }
    @Id
    String id;
    String name;
    Address address;
    String birthDate;
    @Setter
    Curator curator;
}

