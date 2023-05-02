package com.marcelofgaraujo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelofgaraujo.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
	
	public Link findByShortURL(String shortURL);
	public Link findByOriginalURL(String originalURL);
	
}
