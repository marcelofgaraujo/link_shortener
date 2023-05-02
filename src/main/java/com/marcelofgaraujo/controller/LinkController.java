package com.marcelofgaraujo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.marcelofgaraujo.model.Link;
import com.marcelofgaraujo.service.LinkService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LinkController {
	
	private LinkService linkService;
	
	@GetMapping("/{shortURL}")
	public RedirectView redirect(@PathVariable String shortURL) {
		Link link = linkService.findByShortURL(shortURL);
		return new RedirectView(link.getOriginalURL());
	}
	
	@PostMapping
	public String shortenURL(@RequestParam("url") String originalURL) {
		Link originalLink = linkService.findByOriginalURL(originalURL);
		
		if (originalLink != null) {
			return originalLink.getShortURL();
		} else {
			String shortURL = generateShortUrl();
			Link link = new Link();
			link.setOriginalURL(originalURL);
			link.setShortURL(shortURL);
			linkService.saveLink(link);
			return link.getShortURL();
		}
	}
	
	private String generateShortUrl() {
		
		String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		StringBuilder sb = new StringBuilder(6);
		
		for (int i = 0; i <= 6; i++) {
			sb.append(allowedChars.charAt((int) (Math.random() * allowedChars.length())));
		}
		
		return "http://localhost:8080/" + sb.toString();
	}
	
}
