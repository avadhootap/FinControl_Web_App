package com.app.dto;

public class UserDto {
	private Long id;
	private String firstName;
	private String lastname;
	private String city;
	private String email;
	private String password;
	private String confirmPassword;
	
	
	public UserDto() {
		super();
	}
	
	public UserDto(Long id,String firstName, String lastname, String city, String email, String password,
			String confirmPassword) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.city = city;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", city=" + city
				+ ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

	
	
	
	
	
	

}
