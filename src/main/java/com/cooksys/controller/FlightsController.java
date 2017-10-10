package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.FlightDto;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("flights")
@CrossOrigin
public class FlightsController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping
	public List<FlightDto> getFlightList() {
		return flightService.getDailyFlightList();
	}
	
	@GetMapping("/from/@{origin}/to/@{destination}")
	public List<List<FlightDto>> getAllRoutesByOriginAndDestination(@PathVariable String origin, @PathVariable String destination) {
		return flightService.getAllRoutes(origin.toUpperCase(), destination.toUpperCase());
	}
	
	@GetMapping("/direct_from/@{origin}/to/@{destination}")
	public List<FlightDto> getDirectRoutesByOriginAndDestination(@PathVariable String origin, @PathVariable String destination) {
		return flightService.getAllDirectFlights(origin.toUpperCase(), destination.toUpperCase());
	}

}
