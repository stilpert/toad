package com.toad.dykyi.service;

import com.toad.dykyi.dto.CertificateRequestDTO;
import com.toad.dykyi.dto.CertificateResponseDTO;
import com.toad.dykyi.entity.Certificate;
import com.toad.dykyi.mapper.CertificateMapper;
import com.toad.dykyi.repository.CertificateRepository;
import com.toad.dykyi.utils.UniqueCodeGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateService {
    private final CertificateRepository certificateRepository;
    private final UniqueCodeGenerator uniqueCodeGenerator;
    private final CertificateMapper certificateMapper;

    public List<CertificateResponseDTO> getAll() {
        return certificateRepository
                .findAll()
                .stream()
                .map(certificateMapper::toDto)
                .toList();
    }

    public CertificateResponseDTO getById(Long id) {
        return certificateRepository
                .findById(id)
                .map(certificateMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Certificate doesn't exist"));
    }

    public CertificateResponseDTO getByCode(String code) {
        return certificateRepository
                .findByCode(code)
                .map(certificateMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Certificate doesn't exist"));
    }

    @Transactional
    public CertificateResponseDTO save(CertificateRequestDTO
                                               certificateRequestDTO) {
        String code;
        do {
            code = uniqueCodeGenerator.generateUniqueCode();
        } while (certificateRepository.findByCode(code).isPresent());
        Certificate certificate =
                certificateRepository.save(certificateMapper.toEntity(certificateRequestDTO,
                        code));
        return certificateMapper.toDto(certificate);
    }

    public void deleteById(Long id) {
        certificateRepository.deleteById(id);
    }

    @Transactional
    public CertificateResponseDTO updateCredits(Long id, Double credits) {
        Certificate certificate = certificateRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Certificate doesn't exist"));
        certificate.setCredits(credits);
        certificate = certificateRepository.save(certificate);
        return certificateMapper.toDto(certificate);
    }
}