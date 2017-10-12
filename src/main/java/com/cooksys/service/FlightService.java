package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.pojo.Flight;

@Service
public class FlightService {

	@Autowired
	FlightGenerator generator;
	
	private ArrayList<Flight> flightList = new ArrayList<>();
	
	public List<Flight> getDailyFlightList() {
		return flightList;
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=(5000 * 60 * 60))
	private void refreshFlights() {
		flightList = generator.generateNewFlightList();
	}
	
	public List<Flight> getAllDirectFlights(String origin, String destination) {
		List<Flight> directFlights = new ArrayList<>();
		for (Flight f : getDailyFlightList()) {
			if (f.getOrigin().equals(origin) && f.getDestination().equals(destination)) {
				directFlights.add(f);
			}
		}
		return directFlights;
	}
	
	public List<Flight> getIndirectFlightsByDestination(String destination) {
		List<Flight> flights = new ArrayList<>();
		for(Flight f : getDailyFlightList()) {
			if(f.getDestination().equals(destination)) {
				flights.add(f);
			}
		}
		return flights;
	}
	
	public List<Flight> getIndirectFlightsByOrigin(String origin) {
		List<Flight> flights = new ArrayList<>();
		for(Flight f : getDailyFlightList()) {
			if(f.getOrigin().equals(origin)) {
				flights.add(f);
			}
		}
		return flights;
	}
	
	public List<List<Flight>> getAllRoutes(String origin, String destination) {
		List<List<Flight>> allRoutes = new ArrayList<>();
		for(Flight directFlight : getAllDirectFlights(origin, destination)) {
			List<Flight> list = new ArrayList<>();
			list.add(directFlight);
			allRoutes.add(list);
		}
		for(Flight firstLeg : getIndirectFlightsByOrigin(origin)) {
			for(Flight lastLeg : getIndirectFlightsByDestination(destination)) {
				if(firstLeg.getDestination().equals(lastLeg.getOrigin())) {
					List<Flight> list = new ArrayList<>();
					list.add(firstLeg);
					if((firstLeg.getOffsetFromStart() + firstLeg.getFlightTime() + 0.5) < lastLeg.getOffsetFromStart()) {
						list.add(lastLeg);
						allRoutes.add(list);
					}
				} else {
					for(Flight secondLeg : getAllDirectFlights(firstLeg.getDestination(), lastLeg.getOrigin())) {
						List<Flight> list = new ArrayList<>();
						list.add(firstLeg);
						if((firstLeg.getOffsetFromStart() + firstLeg.getFlightTime() + 0.5) < secondLeg.getOffsetFromStart()) {
							list.add(secondLeg);
							if((secondLeg.getOffsetFromStart() + secondLeg.getFlightTime() + 0.5) < lastLeg.getOffsetFromStart()) {
								list.add(lastLeg);
								allRoutes.add(list);
							}
						}
					}
				}
			}
		}
		return allRoutes;
	}
	
}
