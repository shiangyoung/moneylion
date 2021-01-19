package com.example.demo.model;

import java.io.Serializable;

public class FeaturePk implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7332124070836355858L;
	
	/**
	 * Email
	 */
	private String email;
	
	/**
	 * Feat Name
	 */
	private String featName;
	
	/**
	 * Getter for {@link #email}
	 * @return {@link #email}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for {@link #email}
	 * @param featId Value to set {@link #email}
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for {@link #featName}
	 * @return {@link #featName}
	 */
	public String getFeatName() {
		return featName;
	}

	/**
	 * Setter for {@link #featName}
	 * @param featId Value to set {@link #featName}
	 */
	public void setFeatName(String featName) {
		this.featName = featName;
	}
	
	/**
	 * empty constructor
	 */
	public FeaturePk() {
		
	}
	
	/**
	 * default constructor
	 * @param email
	 * @param featName
	 */
	public FeaturePk(String email, String featName) {
		this.email = email;
		this.featName = featName;
	}

}
