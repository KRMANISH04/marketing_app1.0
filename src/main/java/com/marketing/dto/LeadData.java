package com.marketing.dto;
//automatically the form data will go to this class object, you need not to use @ModelAttribute,
//this is not an entity class,it is a ordinary java class
// so just create the variables matching to form, firstName,lastName,email,mobile
public class LeadData {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private long mobile;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
