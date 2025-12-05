package com.toad.certificateservice.dto;

public record CertificateResponseDTO(
        Long id,
        String studentName,
        String courseName,
        Double credits,
        String code
) {
}
