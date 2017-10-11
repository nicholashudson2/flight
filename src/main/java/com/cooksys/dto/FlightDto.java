package com.cooksys.dto;


public class FlightDto {
	
	private long id;
	
	private String origin;
	
	private String destination;
	
	private long flightTime;
	
	private long offsetFromStart;
	
	private long arrival;
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public long getFlightTime() {
		return flightTime;
	}
	
	public void setFlightTime(long flightTime) {
		this.flightTime = flightTime;
	}
	
	public long getOffsetFromStart() {
		return offsetFromStart;
	}
	
	public void setOffsetFromStart(long offset) {
		this.offsetFromStart = offset;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getArrival() {
		return arrival;
	}

	public void setArrival(long arrival) {
		this.arrival = arrival;
	}

}