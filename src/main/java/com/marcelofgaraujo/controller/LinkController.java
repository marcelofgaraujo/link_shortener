package com.marcelofgaraujo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marcelofgaraujo.model.Link;
import com.marcelofgaraujo.service.LinkService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LinkController {
	
	private LinkService linkService;
	
	@PostMapping
	public String shortenURL(@RequestBody String originalURL) {
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
