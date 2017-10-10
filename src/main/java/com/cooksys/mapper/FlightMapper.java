package com.cooksys.mapper;

import java.util.ArrayList;

import org.mapstruct.Mapper;

import com.cooksys.dto.FlightDto;
import com.cooksys.pojo.Flight;

@Mapper(componentModel="spring")
public interface FlightMapper {

	Flight fromDto(FlightDto dto);
	
	FlightDto toFlightDto(Flight flight);
	
	ArrayList<Flight> fromDtos(ArrayList<FlightDto> dtos);
	
	ArrayList<FlightDto> toFlightDtos(ArrayList<Flight> flights);
	
}
