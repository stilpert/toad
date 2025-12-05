package com.toad.certificateservice.dto;

public record CertificateRequestDTO(
        String studentName,
        String courseName,
        Double credits
) {
}