package com.app.pojos;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Income")
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Amount")
	private double amount;
	
	
	@Column(name = "Date")
	private LocalDate date;
	
	@Column(name = "Description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="IncomeType")
	private IncomeCategoryType categoryType;
	
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User users;

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Income() {
		super();
	}

	public Income(Long id, double amount, LocalDate date, String description, IncomeCategoryType categoryType) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.categoryType = categoryType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IncomeCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(IncomeCategoryType categoryType) {
		this.categoryType = categoryType;
	}
	
	@Override
	public String toString() {
		return "Income [id=" + id + ", Amount=" + amount + ", Date=" + date + ", description=" + description
				+ ", categoryType=" + categoryType + ", users=" + users + "]";
	}
	
}
