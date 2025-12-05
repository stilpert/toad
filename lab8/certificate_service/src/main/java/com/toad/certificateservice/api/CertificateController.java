package com.toad.certificateservice.api;

import com.toad.certificateservice.dto.CertificateRequestDTO;
import com.toad.certificateservice.dto.CertificateResponseDTO;
import com.toad.certificateservice.service.CertificateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/certificates")
@RequiredArgsConstructor
public class CertificateController {
    private final CertificateService certificateService;
    @Operation(summary = "Повертає всі сертифікати", description = "Цей метод повертає всі сертифікати")
    @GetMapping("/")
    public ResponseEntity<List<CertificateResponseDTO>> getAllCourses(){
        try{
            List <CertificateResponseDTO> certificates=certificateService.getAll();
            return new ResponseEntity<>(certificates, HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Повертає сертифікат по id", description = "Цей метод повертає сертифікат по id")
    @GetMapping("/{id}")
    public ResponseEntity<CertificateResponseDTO> getById(@PathVariable
                                                          Long id){
        try{
            CertificateResponseDTO certificate=certificateService.getById(id);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Повертає сертифікат по коду", description =
            "Цей метод повертає сертифікат по унікальному коду")
    @GetMapping("by/code/{code}")
    public ResponseEntity<CertificateResponseDTO> getById(@PathVariable
                                                          String code){
        try{
            CertificateResponseDTO
                    certificate=certificateService.getByCode(code);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Створює новий сертифікат", description = "Цей метод дозволяє створити новий сертифікат")
    @PostMapping("/")
    public ResponseEntity<CertificateResponseDTO> addCourse(@RequestBody CertificateRequestDTO certificateRequestDTO){
        try{
            CertificateResponseDTO
                    result=certificateService.save(certificateRequestDTO);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Видаляє сертифікат", description = "Цей метод дозволяє видалити сертитфікаит по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        try{
            certificateService.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Зміна кількості кредитів", description = "Цей метод дозволяє змінити кількість кредитів для існуючого сертифіката по id")
    @PatchMapping("/{id}/credits")
    public ResponseEntity<CertificateResponseDTO>
    updateCredits(@PathVariable Long id, @RequestBody Double credits){
        try{
            CertificateResponseDTO result=certificateService.updateCredits(id,credits);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}