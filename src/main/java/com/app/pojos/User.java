package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="User")
public class User extends BaseEntity1{
	
    @Column(name = "first_name")
	private String firstName;
    
    @Column(name = "last_name")
    private String lastname;
    
    private String city;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    @Column(name = "confirmPassword")
    private String confirmPassword;
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Expense>expense=new ArrayList<Expense>();
    
    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Income>income=new ArrayList<Income>();
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Budget>budget=new ArrayList<Budget>();
    
   
	public User(String firstName, String lastname, String city, String email, String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.city = city;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	
	

	public User() {
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
		return "User [firstName=" + firstName + ", lastname=" + lastname + ", city=" + city + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
    
    
}	