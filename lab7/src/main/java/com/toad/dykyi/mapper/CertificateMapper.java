package com.toad.dykyi.mapper;

import com.toad.dykyi.dto.CertificateRequestDTO;
import com.toad.dykyi.dto.CertificateResponseDTO;
import com.toad.dykyi.entity.Certificate;
import org.springframework.stereotype.Component;

@Component
public class CertificateMapper {
    public Certificate toEntity(CertificateRequestDTO dto, String code){
        return new
                Certificate(dto.studentName(),dto.courseName(),dto.credits(),code);
    }
    public CertificateResponseDTO toDto(Certificate entity){
        return new CertificateResponseDTO(
                entity.getId(),
                entity.getStudentName(),
                entity.getCourseName(),
                entity.getCredits(),
                entity.getCode()
        );
    }
}