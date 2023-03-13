package com.app.dto;

import java.time.LocalDate;

import com.app.pojos.ExpenseCategoryType;

public class UpdateExpenseDto {
	
	private double amount;
	private LocalDate date;
	private String description;
	private ExpenseCategoryType categoryType;
	
	public UpdateExpenseDto(double amount, LocalDate date, String description, ExpenseCategoryType categoryType) {
		super();
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.categoryType = categoryType;
	}
	
	public UpdateExpenseDto() {
		super();
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
		return "UpdateExpenseDto [amount=" + amount + ", date=" + date + ", description=" + description
				+ ", categoryType=" + categoryType + "]";
	}
	
	
	
	
}