package com.dykyi.lab3.automotive.service;

import com.dykyi.lab3.automotive.entity.Owner;
import com.dykyi.lab3.automotive.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    public Owner getById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
    }
}

