package com.dykyi.lab3.study.service;

import com.dykyi.lab3.study.entity.Curator;
import com.dykyi.lab3.study.repository.CuratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuratorService {
    private final CuratorRepository curatorRepository;

    public Curator save(Curator curator) {
        return curatorRepository.save(curator);
    }

    public String getNameById(Long id) {
        Optional<Curator> curator = curatorRepository.findById(id);
        if (curator.isPresent()) {
            return curator.get().getTeacher().getName();
        } else {
            throw new RuntimeException("Curator doesn't exist, id=" + id);
        }
    }
}