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

    public Owner fromDTO(OwnerDTO dto) {
        if (dto == null) return null;
        Owner owner = new Owner();
        owner.setId(dto.getId());
        owner.setName(dto.getName());
        // OwnerType conversion from String to enum
        if (dto.getType() != null) {
            owner.setOwnerType(com.dykyi.toad.automotive.enums.OwnerType.valueOf(dto.getType()));
        }
        return owner;
    }
}
