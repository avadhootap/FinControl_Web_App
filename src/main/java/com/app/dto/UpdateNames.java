package com.app.dto;

public class UpdateNames {
	private String firstName;
	
	private String lastname;

	public UpdateNames(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}

	public UpdateNames() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "UpdateNames [firstName=" + firstName + ", lastname=" + lastname + "]";
	}
	
	
	
	

}
