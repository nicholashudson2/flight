package com.cooksys.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.dto.OutputClientDto;
import com.cooksys.dto.ClientDto;
import com.cooksys.entity.Client;

@Mapper(componentModel="spring")
public interface ClientMapper {

	Client fromDto(ClientDto dto);
	
	OutputClientDto toOutputDto(Client client);
	
	List<Client> fromDtos(List<ClientDto> dtos);
	
	List<OutputClientDto> toOutputDtos(List<Client> clients);
	
}
