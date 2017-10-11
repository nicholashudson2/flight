package com.cooksys.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.entity.Itinerary;
import com.cooksys.dto.ItineraryDto;

@Mapper(componentModel="spring")
public interface ItineraryMapper {

	Itinerary fromDto(ItineraryDto dto);
	
	List<Itinerary> fromDtos(List<ItineraryDto> dtos);
	
	ItineraryDto toDto(Itinerary itinerary);
	
	List<ItineraryDto> toDtos(List<Itinerary> itineraries);
}
