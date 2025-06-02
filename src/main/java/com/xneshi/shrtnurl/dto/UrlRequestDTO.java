package com.xneshi.shrtnurl.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UrlRequestDTO(
    @NotBlank
    String originalUrl,
    @Size(max = 16)
    String customizedName
) {
}
