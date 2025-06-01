package com.xneshi.shrtnurl.service;

import com.xneshi.shrtnurl.respository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {
  private final UrlRepository urlRepository;

}
