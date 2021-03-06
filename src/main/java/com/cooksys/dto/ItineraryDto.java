package com.cooksys.dto;

import java.util.List;

public class ItineraryDto {
	
	private List<String> flightOrigins;
	
	private List<String> flightDestinations;
	
	private List<Long> flightDurations;
	
	private List<Long> flightOffsets;
	
	private List<Long> flightArrivalTimes;
	
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
	
	
	
}
