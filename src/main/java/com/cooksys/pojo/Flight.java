package com.cooksys.pojo;

public class Flight {
	
	//Name of city where flight originates
	private String origin;
	
	//Name of city where flight lands
	private String destination;
	
	//How many hours flight is in the air
	private long flightTime;
	
	//How many hours after the start of the day until the flight takes off
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
	public long getArival() {
		return arrival;
	}
	public void setArrival(long arrival) {
		this.arrival = arrival;
	}
	public Flight(String origin, String destination, long flightTime, long offsetFromStart) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offsetFromStart = offsetFromStart;
		this.arrival = offsetFromStart + flightTime;
	}
	public Flight() {
		super();
	}
	
}
