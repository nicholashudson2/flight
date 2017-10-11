package com.cooksys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.dto.ItineraryDto;
import com.cooksys.mapper.ItineraryMapper;
import com.cooksys.repository.ItineraryRepository;

@Service
public class ItineraryService {
	
	private ItineraryMapper itineraryMapper;
	private ItineraryRepository itineraryRepo;
	
	public ItineraryService(ItineraryMapper itineraryMapper, ItineraryRepository itineraryRepo) {
		this.itineraryMapper = itineraryMapper;
		this.itineraryRepo = itineraryRepo;
	}

	public List<ItineraryDto> findAllByClientCredentialsUsername(String username) {
		return itineraryMapper.toDtos(itineraryRepo.findAllByClientCredentialsUsername(username));
	}
}
