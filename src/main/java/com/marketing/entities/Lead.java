package com.marketing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//it is entity class
//now entity class gets converted into database
@Entity
@Table(name="leads")
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name",nullable = false)
	private String firstName;//in date base first_name
	@Column(name="last_name",nullable = false)
	private String lastName;
    
	@Column(name="email",nullable= false ,unique = true)
	private String email;
	
	@Column(name="mobile",unique=true,nullable=false)
	private long mobile;

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	

}
// end of the entity class