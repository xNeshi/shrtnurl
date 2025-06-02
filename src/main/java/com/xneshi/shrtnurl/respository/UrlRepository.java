package com.xneshi.shrtnurl.respository;

import com.xneshi.shrtnurl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.time.LocalDateTime;

@Repository
public interface UrlRepository extends JpaRepository<Url, UID> {
  Url findByShortCode(String shortCode);
  void deleteAllByExpiresAtBefore(LocalDateTime expiresAt);
}
