package com.xneshi.shrtnurl.dto;

import com.xneshi.shrtnurl.dto.validators.ShortenerUrlValidationGroup;
import jakarta.validation.constraints.NotBlank;

public record UrlRequestDTO(
    @NotBlank
    String shortCode,
    @NotBlank
    String originalUrl
) {
}
