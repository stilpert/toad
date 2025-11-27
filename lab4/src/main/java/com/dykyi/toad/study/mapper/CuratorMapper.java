package com.dykyi.toad.study.mapper;

import com.dykyi.toad.study.dto.CuratorDTO;
import com.dykyi.toad.study.entity.Curator;
import org.springframework.stereotype.Component;

@Component
public class CuratorMapper {
    public CuratorDTO toDTO(Curator curator){
        if(curator==null){
            return null;
        }
        return new CuratorDTO(
                curator.getId(),
                curator.getWorkExperience(),
                curator.getTeacher().getName()
        );
    }
}