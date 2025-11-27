package com.dykyi.toad.automotive.mapper;

import com.dykyi.toad.automotive.dto.OwnerDTO;
import com.dykyi.toad.automotive.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {
    public OwnerDTO toDTO(Owner owner) {
        if (owner == null) return null;
        return new OwnerDTO(
            owner.getId(),
            owner.getName(),
            owner.getOwnerType() != null ? owner.getOwnerType().name() : null
        );
    }
}

