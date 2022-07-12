package com.co.meli.serviceproxy.repository;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.co.meli.serviceproxy.dto.PetitionDTO;

@Service
public class PetitionRepository implements RedisRepository{
	
	private static final String KEY = "PetitionDTO";
	private RedisTemplate<String, PetitionDTO> redisTemplate;
	private HashOperations hashOperations;
	
	public PetitionRepository(RedisTemplate<String, PetitionDTO> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}
	@Override
	public Map<String, PetitionDTO> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public PetitionDTO findById(String id) {
		return (PetitionDTO) hashOperations.get(KEY,id);
	}

	@Override
	public void save(PetitionDTO petition) {
		hashOperations.put(KEY, petition.getId(), petition);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(KEY, id);
	}
	
	

}
