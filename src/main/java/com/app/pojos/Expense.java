package com.app.pojos;

import java.time.Instant;
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

import org.hibernate.annotations.ManyToAny;

import java.util.Date;

@Entity
@Table(name="Expense")
public class Expense {
	
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
	@Column(name="CategoryType")
	private ExpenseCategoryType categoryType;
	
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

	public Expense(Long id, double amount, LocalDate date, String description, ExpenseCategoryType categoryType) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.categoryType = categoryType;
	}

	public Expense() {
		super();
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

	public ExpenseCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(ExpenseCategoryType categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", amount=" + amount + ", date=" + date + ", description=" + description
				+ ", categoryType=" + categoryType + "]";
	}
	
	

	
}
