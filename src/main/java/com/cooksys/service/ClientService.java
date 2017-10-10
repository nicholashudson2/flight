package com.cooksys.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.dto.ClientDto;
import com.cooksys.dto.OutputClientDto;
import com.cooksys.entity.Client;
import com.cooksys.entity.Credentials;
import com.cooksys.mapper.ClientMapper;
import com.cooksys.repository.ClientRepository;



@Service
public class ClientService {

	private ClientRepository clientRepository;
	private ClientMapper clientMapper;

	public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
	}

	public List<OutputClientDto> getActiveUsers() {
		return clientMapper.toOutputDtos(clientRepository.findByActiveTrue());
	}

	public Boolean validateCredentials(Credentials credentials) {
		return clientRepository.validateCredentials(
			clientRepository.findByCredentialsUsername(credentials.getUsername()).getCredentials(), credentials);
	}

	public OutputClientDto findByUsername(String username) {
		return clientMapper.toOutputDto(clientRepository.findByCredentialsUsername(username));
	}

	@Transactional
	public OutputClientDto create(ClientDto client) {
		Client modifiedUser = clientRepository.findByCredentialsUsername(client.getCredentials().getUsername());
		if (modifiedUser != null) {
			if (modifiedUser.getActive() == false) {
				modifiedUser.setActive(true);
				modifiedUser.setUsername(modifiedUser.getCredentials().getUsername());
				clientRepository.save(modifiedUser);
			}
		} else {
			clientRepository.save(clientMapper.fromDto(client));
		}
		return findByUsername(client.getCredentials().getUsername());
	}

	@Transactional
	public OutputClientDto deactivateUser(String username, Credentials credentials) {
		Client modifiedUser = clientRepository.findByCredentialsUsername(credentials.getUsername());
		if (modifiedUser != null && clientRepository.validateCredentials(clientRepository.findByCredentialsUsername(username).getCredentials(), credentials)) {
			modifiedUser.setActive(false);
			clientRepository.save(modifiedUser);
		}
		return clientMapper.toOutputDto(modifiedUser);
	}

	public Boolean checkIfActive(String username) {
		return (clientRepository.findByCredentialsUsername(username)).getActive();
	}

	@Transactional
	public OutputClientDto reactivateUser(String username, Credentials credentials) {
		Client modifiedUser = clientRepository.findByCredentialsUsername(credentials.getUsername());
		if (modifiedUser != null && clientRepository.validateCredentials(
				clientRepository.findByCredentialsUsername(username).getCredentials(), credentials)) {
			modifiedUser.setActive(true);
			clientRepository.save(modifiedUser);
		}
		return clientMapper.toOutputDto(modifiedUser);
	}

	@Transactional
	public OutputClientDto updateUser(String username, ClientDto client) {
		Client modifiedUser = clientRepository.findByCredentialsUsername(username);
		if (modifiedUser != null) {
			if (clientRepository.validateCredentials(clientRepository.findByCredentialsUsername(username).getCredentials(), client.getCredentials())) {
				if (modifiedUser.getActive()) {
					modifiedUser.setProfile(client.getProfile());
				}
				modifiedUser.setActive(true);
				modifiedUser.setProfile(client.getProfile());
			}
			clientRepository.save(modifiedUser);
		}
		return clientMapper.toOutputDto(modifiedUser);
	}

}
