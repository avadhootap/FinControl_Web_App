package com.app.model;

import com.app.dto.UserDto;

public class JwtResponse{
	private String token;
	private UserDto dto;
	
	public JwtResponse() {
		
	}
	
	
	public JwtResponse(UserDto dto) {
		super();
		this.dto = dto;
	}


	public JwtResponse(String token, UserDto dto) {
		super();
		this.token = token;
		this.dto = dto;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDto getDto() {
		return dto;
	}

	public void setDto(UserDto dto) {
		this.dto = dto;
	}
	
	

}
