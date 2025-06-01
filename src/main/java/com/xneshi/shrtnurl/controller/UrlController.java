package com.xneshi.shrtnurl.controller;

import com.xneshi.shrtnurl.dto.UrlRequestDTO;
import com.xneshi.shrtnurl.dto.UrlResponseDTO;
import com.xneshi.shrtnurl.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {
  private final UrlService urlService;

  @PostMapping("/shorten")
  public ResponseEntity<UrlResponseDTO> shortenUrl(
      @Valid @RequestBody UrlRequestDTO url
  ) {
    return ResponseEntity.ok(urlService.shortenUrl(url));
  }

  @GetMapping("/{shortCode}")
  public ResponseEntity<Void> redirectToOriginalUrl(
      @PathVariable String shortCode
  ) {
      return ResponseEntity.status(HttpStatus.FOUND)
          .location(URI.create(urlService.findOriginalUrl(shortCode)))
          .build();
  }
}
