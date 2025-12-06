package com.dykyi.toad.mapper;

import com.dykyi.toad.dto.CuratorDTO;
import com.dykyi.toad.entity.Curator;
import org.springframework.stereotype.Component;

@Component
public class CuratorMapper {
    public CuratorDTO toDTO(Curator curator){
        if(curator==null){
            return null;
        }
        String name;
        if(curator.getTeacher()==null){
            name = "невідоме";
        }else{
            name =curator.getTeacher().getName();
        }
        return new CuratorDTO(
                curator.getId(),
                curator.getWorkExperience(),
                name
        );
    }
}