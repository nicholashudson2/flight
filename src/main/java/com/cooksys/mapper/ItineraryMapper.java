package com.cooksys.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.dto.InputItineraryDto;
import com.cooksys.dto.ItineraryDto;
import com.cooksys.entity.Itinerary;

@Mapper(componentModel="spring")
public interface ItineraryMapper {

	Itinerary fromInputDto(InputItineraryDto dto);
	
	ItineraryDto toDto(Itinerary itinerary);
	
	Itinerary fromDto(ItineraryDto dto);
	
	List<Itinerary> fromDtos(List<InputItineraryDto> dtos);
	
	List<ItineraryDto> toDtos(List<Itinerary> itineraries);
	
}