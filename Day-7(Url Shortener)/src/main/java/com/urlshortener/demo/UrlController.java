package com.urlshortener.demo;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UrlController {
  @Autowired
  private UrlRepository urlRepository;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @PostMapping("/shorten")
  public String shortenUrl(@RequestParam("url") String originalUrl, Model model) {
    String md5Hash = DigestUtils.md5Hex(originalUrl);
    String shortUrl = md5Hash.substring(0, 8); // Use the first 8 characters as the short URL

    Url url = new Url();
    url.setOriginalUrl(originalUrl);
    url.setShortUrl(shortUrl);
    urlRepository.save(url);

    model.addAttribute("shortUrl", shortUrl);
    return "result";
  }

  @GetMapping("/{shortUrl}")
  public RedirectView redirect(@RequestParam("shortUrl") String shortUrl) {
    Url url = urlRepository.findByShortUrl(shortUrl);
    if (url != null) {
      return new RedirectView(url.getOriginalUrl());
    } else {
      return new RedirectView("/");
    }
  }
}
