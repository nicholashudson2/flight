package com.cooksys.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.dto.InputItineraryDto;
import com.cooksys.dto.ItineraryDto;
import com.cooksys.entity.Itinerary;
import com.cooksys.mapper.ItineraryMapper;
import com.cooksys.repository.ClientRepository;
import com.cooksys.repository.ItineraryRepository;

@Service
public class ItineraryService {
	
	private ItineraryMapper itineraryMapper;
	private ItineraryRepository itineraryRepo;
	private ClientRepository clientRepo;
	
	public ItineraryService(ItineraryMapper itineraryMapper, ItineraryRepository itineraryRepo, ClientRepository clientRepo) {
		this.itineraryMapper = itineraryMapper;
		this.itineraryRepo = itineraryRepo;
		this.clientRepo = clientRepo;
	}

	public List<ItineraryDto> findAllByClientCredentialsUsername(String username) {
		return itineraryMapper.toDtos(itineraryRepo.findAllByClientCredentialsUsername(username));
	}

	public ItineraryDto findById(long id) {
		return itineraryMapper.toDto(itineraryRepo.findById(id));
	}

	@Transactional
	public ItineraryDto create(InputItineraryDto itinerary) {
		Itinerary modifiedItinerary = itineraryMapper.fromDto(itinerary);
		modifiedItinerary.setClient(clientRepo.findByCredentialsUsername(itinerary.getCredentials().getUsername()));
		return itineraryMapper.toDto(itineraryRepo.save(modifiedItinerary));
		
	}
	
}
