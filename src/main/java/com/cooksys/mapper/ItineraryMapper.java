package com.cooksys.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.entity.Itinerary;
import com.cooksys.dto.InputItineraryDto;
import com.cooksys.dto.ItineraryDto;

@Mapper(componentModel="spring")
public interface ItineraryMapper {

	Itinerary fromDto(InputItineraryDto dto);
	
	List<Itinerary> fromDtos(List<InputItineraryDto> dtos);
	
	ItineraryDto toDto(Itinerary itinerary);
	
	List<ItineraryDto> toDtos(List<Itinerary> itineraries);
}
