package com.dykyi.lab3.study.api;

import com.dykyi.lab3.study.service.CuratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/curators")
@RequiredArgsConstructor
public class CuratorController {
    private final CuratorService curatorService;
    @GetMapping("/{id}/name")
    public ResponseEntity<String> getCuratorName(@PathVariable Long id){
        try{
            String name=curatorService.getNameById(id);
            return new ResponseEntity<>(name, HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}