package com.xneshi.shrtnurl.mapper;

import com.xneshi.shrtnurl.dto.UrlRequestDTO;
import com.xneshi.shrtnurl.dto.UrlResponseDTO;
import com.xneshi.shrtnurl.model.Url;

public class UrlMapper {

  static public Url toUrl(UrlRequestDTO urlRequestDTO) {
    Url url = new Url();
    url.setOriginalUrl(urlRequestDTO.originalUrl());
    return url;
  }

  static public UrlResponseDTO toUrlResponseDTO(Url url) {
    return new UrlResponseDTO(
        url.getShortCode()
    );
  }
}
