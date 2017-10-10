package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.repository.LocationRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepo;
		
	public List<Location> getAll()
	{
		return clientRepo.findAll();
	}

	public Location get(long id) {
		return clientRepo.findById(id);
	}
	
	public Location get(String name) {
		return clientRepo.findByCity(name);
	}
}
