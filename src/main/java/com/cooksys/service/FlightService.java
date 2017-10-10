package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.dto.FlightDto;
import com.cooksys.mapper.FlightMapper;
import com.cooksys.pojo.Flight;

@Service
public class FlightService {

	@Autowired
	FlightGenerator generator;
	
	@Autowired
	FlightMapper flightMapper;

	private ArrayList<Flight> flightList = new ArrayList<>();
	
	public List<FlightDto> getDailyFlightList() {
		return flightMapper.toFlightDtos(flightList);
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=(5000 * 60 * 60))
	private void refreshFlights() {
		flightList = generator.generateNewFlightList();
	}
	
	public List<FlightDto> getAllDirectFlights(String origin, String destination) {
		List<FlightDto> directFlights = new ArrayList<>();
		for (FlightDto f : getDailyFlightList()) {
			if (f.getOrigin().equals(origin) && f.getDestination().equals(destination)) {
				directFlights.add(f);
			}
		}
		return directFlights;
	}
	
	public List<FlightDto> getIndirectFlightsByDestination(String destination) {
		List<FlightDto> flights = new ArrayList<>();
		for(FlightDto f : getDailyFlightList()) {
			if(f.getDestination().equals(destination)) {
				flights.add(f);
			}
		}
		return flights;
	}
	
	public List<FlightDto> getIndirectFlightsByOrigin(String origin) {
		List<FlightDto> flights = new ArrayList<>();
		for(FlightDto f : getDailyFlightList()) {
			if(f.getOrigin().equals(origin)) {
				flights.add(f);
			}
		}
		return flights;
	}
	
	public List<List<FlightDto>> getAllRoutes(String origin, String destination) {
		List<List<FlightDto>> allRoutes = new ArrayList<>();
		for(FlightDto directFlight : getAllDirectFlights(origin, destination)) {
			List<FlightDto> list = new ArrayList<>();
			list.add(directFlight);
			allRoutes.add(list);
		}
		for(FlightDto firstLeg : getIndirectFlightsByOrigin(origin)) {
			for(FlightDto lastLeg : getIndirectFlightsByDestination(destination)) {
				if(firstLeg.getDestination().equals(lastLeg.getOrigin())) {
					List<FlightDto> list = new ArrayList<>();
					list.add(firstLeg);
					if((firstLeg.getOffsetFromStart() + firstLeg.getFlightTime() + 0.5) < lastLeg.getOffsetFromStart()) {
						list.add(lastLeg);
						allRoutes.add(list);
					}
				} else {
					for(FlightDto secondLeg : getAllDirectFlights(firstLeg.getDestination(), lastLeg.getOrigin())) {
						List<FlightDto> list = new ArrayList<>();
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
