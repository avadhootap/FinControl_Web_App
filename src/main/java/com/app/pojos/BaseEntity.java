package com.app.pojos;

import java.time.Instant;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	public BaseEntity(Long id, String name, double amount, Instant date, String description) {
		super();
		this.id = id;
		this.name = name;
		Amount = amount;
		Date = date;
		this.description = description;
	}
	
	
	public BaseEntity() {
		super();
	}


	@Column(name ="Name")
	private String name;
	
	@Column(name = "Amount")
	private double Amount;
	
	@Column(name = "Date")
	private Instant Date;
	
	@Column(name = "Description")
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public Instant getDate() {
		return Date;
	}
	public void setDate(Instant date) {
		Date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", name=" + name + ", Amount=" + Amount + ", Date=" + Date + ", description="
				+ description + "]";
	}
	
	
}
