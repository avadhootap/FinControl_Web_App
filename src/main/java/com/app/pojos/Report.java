package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "report")
	public class Report {
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @Column(name = "start_date")
	    private LocalDate startDate;
	 
	    @Column(name = "end_date")
	    private LocalDate endDate;
	 
//	    @OneToOne
//	    @JoinColumn(name = "expense_id")
//	    private Expense expense;

		public Report(Long id, LocalDate startDate, LocalDate endDate) {
			super();
			this.id = id;
			this.startDate = startDate;
			this.endDate = endDate;
		}

		public Report() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
			return "Report [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + "]";
		}
		
		
	    
	    
}
