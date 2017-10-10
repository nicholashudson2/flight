package com.cooksys.dto;


public class FlightDto {
	
	private String origin;
	
	private String destination;
	
	private long flightTime;
	
	private long offsetFromStart;
	
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

}