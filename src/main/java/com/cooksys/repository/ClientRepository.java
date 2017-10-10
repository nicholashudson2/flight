package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.entity.Client;
import com.cooksys.entity.Credentials;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	Client findByCredentialsUsername(String username);
	
	List<Client> getFollowersByActiveTrue(Client client);
	
	List<Client> findByActiveTrue();
	
	public default Boolean validateCredentials(Credentials validate, Credentials credentials) {
		return credentials.getPassword().equals(validate.getPassword());
	}
	
	Client findByCredentialsAndActive(Credentials credentials, Boolean active);
}