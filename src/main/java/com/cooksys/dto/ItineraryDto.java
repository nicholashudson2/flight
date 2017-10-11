package com.cooksys.dto;

import java.util.List;

import com.cooksys.entity.Client;
import com.cooksys.pojo.Flight;

public class ItineraryDto {

	private long id;
	
	private List<Flight> flights;
	
	private Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
