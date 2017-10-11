package com.cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.ItineraryDto;
import com.cooksys.entity.Credentials;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.service.ItineraryService;

@RestController
@RequestMapping("itinerary")
@CrossOrigin
public class ItineraryController {
	
	ItineraryService itineraryService;
	ItineraryRepository itineraryRepo;
	
	public ItineraryController(ItineraryService itineraryService, ItineraryRepository itineraryRepo) {
		this.itineraryService = itineraryService;
		this.itineraryRepo = itineraryRepo;
	}

	@GetMapping
	public List<ItineraryDto> findAllByClientCredentialsUsername(@RequestBody Credentials credentials) {
		return itineraryService.findAllByClientCredentialsUsername(credentials.getUsername());
	}
	
	@PostMapping
	public ItineraryDto create(@RequestBody ItineraryDto itinerary) {
		itineraryService.create(itinerary);
		return itineraryService.findById(itinerary.getId());
	}
}
