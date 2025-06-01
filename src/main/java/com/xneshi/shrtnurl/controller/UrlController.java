package com.xneshi.shrtnurl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UrlController {

  @PostMapping("/shorten")
  public ResponseEntity<String> shortenUrl(
      @RequestBody String url
  ) {
    return ResponseEntity.ok("");
  }

  @GetMapping("/{shortCode}")
  public ResponseEntity<String> fetchOriginalUrl(
      @PathVariable String shortCode
  ) {
    return ResponseEntity.ok("");
  }
}
