package com.co.meli.serviceproxy.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.co.meli.serviceproxy.dto.StatisticalDTO;

@Service
public class StatisticalRepository implements IStatisticalRepository{
	
	
	private static final String KEY = "StatisticalDTO";
	private RedisTemplate<String, StatisticalDTO> redisTemplate;
	private HashOperations hashOperations;
	
	public StatisticalRepository(RedisTemplate<String, StatisticalDTO> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}
	@Override
	public Map<String, StatisticalDTO> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public StatisticalDTO findById(String id) {
		return (StatisticalDTO) hashOperations.get(KEY,id);
	}

	@Override
	public void save(StatisticalDTO statistical) {
		hashOperations.put(KEY, statistical.getIp(), statistical);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(KEY, id);
	}

}
