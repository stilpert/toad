package com.dykyi.toad.automotive.dto;

import com.dykyi.toad.automotive.dto.CarPartDTO;
import com.dykyi.toad.automotive.dto.OwnerDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class CarDTO {
    Long id;
    String model;
    OwnerDTO owner;
    List<CarPartDTO> parts;
}