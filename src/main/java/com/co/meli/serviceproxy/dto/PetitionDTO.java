package com.co.meli.serviceproxy.dto;

import java.io.Serializable;

public class PetitionDTO  implements Serializable {
	private static final long serialVersionUID = -6850522852835113796L;
	private String id;
	private int petition;
	private long startDate;
	private long executionDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPeticiones() {
		return petition;
	}
	public void setPeticiones(int petition) {
		this.petition = petition;
	}
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(long executionDate) {
		this.executionDate = executionDate;
	}
	
	

}
