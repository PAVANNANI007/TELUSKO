package com.urlshortener.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Url {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String originalUrl;
  private String shortUrl;

  public void setShortUrl(String shortUrl2) {
  }

  public void setOriginalUrl(String originalUrl2) {
  }

  public String getOriginalUrl() {
    return null;
  }

  // Constructors, getters, and setters
}
