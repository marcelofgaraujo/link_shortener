package com.marcelofgaraujo.service;

import org.springframework.stereotype.Service;

import com.marcelofgaraujo.model.Link;
import com.marcelofgaraujo.repository.LinkRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class LinkService {
	
	private LinkRepository linkRepository;
	
	public Link saveLink(Link link) {
		linkRepository.save(link);
		return link;
	}
	
	public Link findByOriginalURL(String url) {
		return linkRepository.findByOriginalURL(url);
	}
	
	public Link findByShortURL(String shortURL) {
		return linkRepository.findByShortURL(shortURL);
	}
	
}
