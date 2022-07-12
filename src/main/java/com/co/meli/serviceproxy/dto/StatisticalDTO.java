package com.co.meli.serviceproxy.dto;

import java.io.Serializable;

public class StatisticalDTO implements Serializable{

	private static final long serialVersionUID = -9143336327597739746L;
	
	private String idCategorie;
	private String ip;
	private int coutPetition;
	private int coutPetitionCancelled;
	private String description;
	
	public String getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCoutPetition() {
		return coutPetition;
	}
	public void setCoutPetition(int coutPetition) {
		this.coutPetition = coutPetition;
	}
	public int getCoutPetitionCancelled() {
		return coutPetitionCancelled;
	}
	public void setCoutPetitionCancelled(int coutPetitionCancelled) {
		this.coutPetitionCancelled = coutPetitionCancelled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
