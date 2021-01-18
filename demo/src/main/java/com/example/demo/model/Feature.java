package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Feature Model Class
 * @author Shawn Tan
 *
 */
@Entity
@Table(name = "FEATURE")
public class Feature {

	/**
	 * Primary Key. Feat Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer featId;
	
	/**
	 * Email
	 */
	private String email;
	
	/**
	 * Feat Name
	 */
	private String featName;
	
	/**
	 * Access
	 */
	private boolean access;

	public int getFeatId() {
		return featId;
	}

	public void setFeatId(int featId) {
		this.featId = featId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeatName() {
		return featName;
	}

	public void setFeatName(String featName) {
		this.featName = featName;
	}

	public boolean getAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "Feature [featId=" + featId + "]";
	}
	
}
