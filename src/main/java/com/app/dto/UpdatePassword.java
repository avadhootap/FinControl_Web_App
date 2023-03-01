package com.app.dto;

public class UpdatePassword {
	
	private String password;
	private String confirmPassword;
	
	public UpdatePassword(String password, String confirmPassword) {
		super();
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public UpdatePassword() {
		super();
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
		return "UpdatePassword [password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

	
	

}
