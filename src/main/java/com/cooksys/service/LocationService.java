package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository repo;
		
	public List<Location> getAll()
	{
		return repo.findAll();
	}

	public Location get(long id) {
		return repo.findById(id);
	}
	
	public Location get(String name) {
		String output = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		System.out.println(output);
		return repo.findByCity(output);
	}
}