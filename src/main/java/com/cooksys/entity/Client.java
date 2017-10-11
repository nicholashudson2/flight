package com.cooksys.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Client")
public class Client {

	@Transient
	java.util.Date today = new java.util.Date();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private boolean active;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private final Timestamp joined = new java.sql.Timestamp(today.getTime());

	@Embedded
	private Profile profile;

	@Embedded
	private Credentials credentials;
	
	@OneToMany(mappedBy="client")
	private List<Itinerary> itineraries;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return credentials.getUsername();
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.credentials.setUsername(username);
	}

	/**
	 * @return the credentials
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials
	 *            the credentials to set
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
