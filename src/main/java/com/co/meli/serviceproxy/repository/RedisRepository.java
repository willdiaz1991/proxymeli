package com.co.meli.serviceproxy.repository;

import java.util.Map;

import com.co.meli.serviceproxy.dto.PetitionDTO;

public interface RedisRepository {
	Map<String,PetitionDTO> findAll();
	PetitionDTO findById(String id);
	void save(PetitionDTO petition);
	void delete(String id);

}
