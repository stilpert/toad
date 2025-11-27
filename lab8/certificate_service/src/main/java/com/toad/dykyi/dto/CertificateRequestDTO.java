package com.toad.dykyi.dto;

public record CertificateRequestDTO(
        String studentName,
        String courseName,
        Double credits
) {
}