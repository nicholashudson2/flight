package com.cooksys.entity;

import java.sql.Timestamp;
import java.util.Date;
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
	
	public Client() {
		super();
	}

	public Client(Date today, long id, boolean active, Profile profile, Credentials credentials,
			List<Itinerary> itineraries) {
		super();
		this.today = today;
		this.id = id;
		this.active = active;
		this.profile = profile;
		this.credentials = credentials;
		this.itineraries = itineraries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
