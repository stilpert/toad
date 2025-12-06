package com.dykyi.lab13.dto;

import java.util.List;

public record MovieWithRolesDto(
        String name,
        List<String> roles
) {
}