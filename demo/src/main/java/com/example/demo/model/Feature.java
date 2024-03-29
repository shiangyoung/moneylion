package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Feature Model Class
 * @author Shawn Tan
 *
 */
@Entity
@IdClass(FeaturePk.class)
public class Feature {
	
	/**
	 * Email
	 */
	@Id
	private String email;
	
	/**
	 * Feat Name
	 */
	@Id
	private String featName;
	
	/**
	 * Access
	 */
	private boolean access;

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
	 * Getter for {@link #access}
	 * @return {@link #access}
	 */
	public boolean getAccess() {
		return access;
	}

	/**
	 * Setter for {@link #access}
	 * @param featId Value to set {@link #access}
	 */
	public void setAccess(boolean access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "Feature [email=" + email + ", featName=" + featName + "]";
	}
	
}
