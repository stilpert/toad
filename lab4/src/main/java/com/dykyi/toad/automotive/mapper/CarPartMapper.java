package com.dykyi.toad.automotive.mapper;

import com.dykyi.toad.automotive.dto.CarPartDTO;
import com.dykyi.toad.automotive.entity.CarPart;
import org.springframework.stereotype.Component;

@Component
public class CarPartMapper {
    public CarPartDTO toDTO(CarPart carPart) {
        if (carPart == null) return null;
        return new CarPartDTO(
                carPart.getId(),
                carPart.getName()
        );
    }
}