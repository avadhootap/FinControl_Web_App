package com.app.dto;
import com.app.pojos.IncomeCategoryType;

import java.time.LocalDate;

public class UpdateIncomeDto {
	
	private double amount;
	private LocalDate date;
	private String description;
	private IncomeCategoryType categoryType;
	
	public UpdateIncomeDto(double amount, LocalDate date, String description, IncomeCategoryType categoryType) {
		super();
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.categoryType = categoryType;
	}

	public UpdateIncomeDto() {
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

	public IncomeCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(IncomeCategoryType categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "UpdateIncomeDto [amount=" + amount + ", date=" + date + ", description=" + description
				+ ", categoryType=" + categoryType + "]";
	}
	
	
	
	
	

}
