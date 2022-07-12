package com.co.meli.serviceproxy.repository;

import java.util.Map;

import com.co.meli.serviceproxy.dto.StatisticalDTO;


public interface IStatisticalRepository {
	
	Map<String,StatisticalDTO> findAll();
	StatisticalDTO findById(String id);
	void save(StatisticalDTO petition);
	void delete(String id);

}
