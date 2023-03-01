package com.app.pojos;

import javax.persistence.MappedSuperclass;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
