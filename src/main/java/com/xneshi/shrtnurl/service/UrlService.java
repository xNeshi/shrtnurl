package com.xneshi.shrtnurl.service;

import com.xneshi.shrtnurl.dto.UrlRequestDTO;
import com.xneshi.shrtnurl.dto.UrlResponseDTO;
import com.xneshi.shrtnurl.mapper.UrlMapper;
import com.xneshi.shrtnurl.model.Url;
import com.xneshi.shrtnurl.respository.UrlRepository;
import com.xneshi.shrtnurl.util.ShortenerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlService {
  private final UrlRepository urlRepository;

  public UrlResponseDTO shortenUrl(UrlRequestDTO url) {
    var shortenedUrl = UrlMapper.toUrl(url);
    shortenedUrl.setCreatedAt(LocalDateTime.now());
    shortenedUrl.setExpiresAt(LocalDateTime.now().plusDays(30));

    if (url.customizedName() != null && !url.customizedName().isBlank()) {
      shortenedUrl.setShortCode(url.customizedName());
    } else {
      shortenedUrl.setShortCode(ShortenerUtil.hashUrl(url.originalUrl()));
    }

    urlRepository.save(shortenedUrl);

    return UrlMapper.toUrlResponseDTO(shortenedUrl);
  }

  public String findOriginalUrl(String shortCode) {
    Url url = urlRepository.findByShortCode(shortCode);
    return url.getOriginalUrl();
  }

  @Scheduled(cron = "0 0 0 * * *")
  public void expireUrls() {
    urlRepository.deleteAllByExpiresAtBefore(LocalDateTime.now());
  }
}
