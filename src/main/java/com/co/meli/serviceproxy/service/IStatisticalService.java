package com.co.meli.serviceproxy.service;

import java.util.Map;

import com.co.meli.serviceproxy.dto.StatisticalDTO;

public interface IStatisticalService {
	
	public void statisticalPetitionsMeli(StatisticalDTO data,boolean isCorrect);
	
	public Map<String, StatisticalDTO> statisticalallPetitions();

}
