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

@Entity
@Table(name="Budget")
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BudgetType")
	private BudgetType budgetType;
	
	@Column(name = "Budget_Limit")
	private Double b_limit;
	
	@Column(name = "StartDate")
	private LocalDate startDate;
	
	@Column(name = "EndDate")
	private LocalDate endDate;
	
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private User buser;

	public Budget(Long id, String description, BudgetType budgetType, Double b_limit, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.id = id;
		this.description = description;
		this.budgetType = budgetType;
		this.b_limit = b_limit;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Budget() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BudgetType getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(BudgetType budgetType) {
		this.budgetType = budgetType;
	}

	public Double getB_limit() {
		return b_limit;
	}

	public void setB_limit(Double b_limit) {
		this.b_limit = b_limit;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Budget [id=" + id + ", description=" + description + ", budgetType=" + budgetType + ", b_limit="
				+ b_limit + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}



}
