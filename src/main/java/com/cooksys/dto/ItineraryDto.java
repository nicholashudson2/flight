package com.cooksys.dto;

import java.util.List;

import com.cooksys.entity.Client;

public class ItineraryDto {

	private long id;
	
	private List<FlightDto> flights;
	
	private Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<FlightDto> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDto> flights) {
		this.flights = flights;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
