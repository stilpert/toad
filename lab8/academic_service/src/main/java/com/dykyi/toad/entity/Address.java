package com.dykyi.toad.entity;

import com.dykyi.toad.enums.Country;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Address {
    static final long serialVersionUID = 1L;
    @Column(name = "postal_code")
    String postalCode;
    @Column(nullable = false)
    String street;
    @Column(nullable = false)
    String city;
    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    Country country;
}