package com.xneshi.shrtnurl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Url {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String originalUrl;
  private String shortCode;
  private LocalDateTime createdAt;
  private LocalDateTime expiresAt;
}
