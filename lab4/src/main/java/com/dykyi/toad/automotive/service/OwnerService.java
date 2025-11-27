package com.dykyi.toad.automotive.service;

import com.dykyi.toad.automotive.dto.OwnerDTO;
import com.dykyi.toad.automotive.entity.Owner;
import com.dykyi.toad.automotive.mapper.OwnerMapper;
import com.dykyi.toad.automotive.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<OwnerDTO> getAll() {
        return ownerRepository.findAll().stream().map(ownerMapper::toDTO).toList();
    }

    public OwnerDTO getById(Long id) {
        return ownerMapper.toDTO(ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found")));
    }
}
