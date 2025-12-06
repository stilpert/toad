package com.dykyi.lab13.dto;

import lombok.Getter;

public record MovieDto(
        Long id,
        String title,
        String tagline,
        Integer released
) {
}