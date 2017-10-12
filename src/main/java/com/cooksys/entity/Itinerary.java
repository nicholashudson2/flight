package com.cooksys.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Itinerary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ElementCollection
	private List<String> flightOrigins;
	@ElementCollection
	private List<String> flightDestinations;
	@ElementCollection
	private List<Long> flightDurations;
	@ElementCollection
	private List<Long> flightOffsets;
	@ElementCollection
	private List<Long> flightArrivalTimes;
	
	@ManyToOne
	private Client client;

	public long getId() {
		return id;
	}

	public List<String> getFlightOrigins() {
		return flightOrigins;
	}

	public void setFlightOrigins(List<String> flightOrigins) {
		this.flightOrigins = flightOrigins;
	}

	public List<String> getFlightDestinations() {
		return flightDestinations;
	}

	public void setFlightDestinations(List<String> flightDestinations) {
		this.flightDestinations = flightDestinations;
	}

	public List<Long> getFlightDurations() {
		return flightDurations;
	}

	public void setFlightDurations(List<Long> flightDurations) {
		this.flightDurations = flightDurations;
	}

	public List<Long> getFlightOffsets() {
		return flightOffsets;
	}

	public void setFlightOffsets(List<Long> flightOffsets) {
		this.flightOffsets = flightOffsets;
	}

	public List<Long> getFlightArrivalTimes() {
		return flightArrivalTimes;
	}

	public void setFlightArrivalTimes(List<Long> flightArrivalTimes) {
		this.flightArrivalTimes = flightArrivalTimes;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Itinerary(List<String> flightOrigins, List<String> flightDestinations, List<Long> flightDurations,
			List<Long> flightOffsets, List<Long> flightArrivalTimes, Client client) {
		super();
		this.flightOrigins = flightOrigins;
		this.flightDestinations = flightDestinations;
		this.flightDurations = flightDurations;
		this.flightOffsets = flightOffsets;
		this.flightArrivalTimes = flightArrivalTimes;
		this.client = client;
	}

	public Itinerary() {
		super();
	}
	
}
