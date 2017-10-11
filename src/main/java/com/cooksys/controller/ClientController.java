package com.cooksys.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.ClientDto;
import com.cooksys.dto.OutputClientDto;
import com.cooksys.entity.Credentials;
import com.cooksys.repository.ClientRepository;
import com.cooksys.service.ClientService;

@RestController
@RequestMapping("client")
@CrossOrigin
public class ClientController {
	
	ClientService clientService;
	ClientRepository clientRepository;
	
	public ClientController(ClientService clientService, ClientRepository clientRepository) {
		this.clientService = clientService;
		this.clientRepository = clientRepository;
	}
	
	@PostMapping("login")
	public boolean clientAuthentication(@RequestBody Credentials credentials){   //Artem added
		System.out.println(clientService.clientAuthentication(credentials));
		return clientService.clientAuthentication(credentials);
	}
	
	@GetMapping("validate/username/exists/@{username}")
	public Boolean validateExistingUsername(@PathVariable String username) {
		return (clientService.findByUsername(username) != null && clientService.checkIfActive(username)) ? true : false;
	}
	
	@GetMapping("validate/username/available/@{username}")
	public Boolean validateAvailableUsername(@PathVariable String username) {
		return (clientService.findByUsername(username) != null) ? false : true;
	}
	
	@GetMapping
	public List<OutputClientDto> users() {
		return clientService.getActiveUsers();
	}


	@PostMapping
	public OutputClientDto createClient(@RequestBody ClientDto client) {
		clientService.create(client);
		return clientService.findByUsername(client.getCredentials().getUsername());
	}

	@GetMapping("@{username}")
	public OutputClientDto findByUsername(@PathVariable String username, HttpServletResponse response) {
		return clientService.findByUsername(username);
	}

	@PatchMapping("@{username}")
	public OutputClientDto updateUser(@PathVariable String username, @RequestBody ClientDto person, HttpServletResponse response) {
		if (!validateExistingUsername(username) || !clientService.validateCredentials(person.getCredentials()))
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
		return clientService.updateUser(username, person);
	}

	@DeleteMapping("@{username}")
	public OutputClientDto deleteByUsername(@PathVariable String username, @RequestBody Credentials credentials, HttpServletResponse response) {
		if (!validateExistingUsername(username) || !clientService.validateCredentials(credentials))
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return clientService.deactivateUser(username, credentials);
	}

//	@GetMapping("users/@{username}/history")
//	public List<ItineraryDto> getItineraries(@PathVariable String username, HttpServletResponse response) {
//		List<ItineraryDto> history = clientService.findItineraries(username);
//		if (history.isEmpty()) {
//			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
//		} 
//		return history;
//	}

}

