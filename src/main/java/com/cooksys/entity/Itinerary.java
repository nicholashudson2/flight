package com.cooksys.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.cooksys.pojo.Flight;


@Entity
public class Itinerary {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	private List<Flight> flights;
	
	@ManyToOne
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

	public Itinerary(long id, List<Flight> flights, Client client) {
		super();
		this.id = id;
		this.flights = flights;
		this.client = client;
	}

	public Itinerary() {
		super();
	}
	
}
