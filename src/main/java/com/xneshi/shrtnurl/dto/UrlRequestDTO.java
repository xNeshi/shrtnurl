package com.xneshi.shrtnurl.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlRequestDTO(
    @NotBlank
    String originalUrl
) {
}
