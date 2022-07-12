package com.co.meli.serviceproxy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.co.meli.serviceproxy.dto.PetitionDTO;
import com.co.meli.serviceproxy.dto.StatisticalDTO;

@Configuration
public class RedisConfiguration {
	
	@Bean
	JedisConnectionFactory jedisConnectionFacotry() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	RedisTemplate<String,PetitionDTO> redisTemplate(){
		final RedisTemplate<String,PetitionDTO> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFacotry());
		return redisTemplate;
		
	}
	
	@Bean
	RedisTemplate<String,StatisticalDTO> redisTemplateStatiscal(){
		final RedisTemplate<String,StatisticalDTO> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFacotry());
		return redisTemplate;
		
	}
}
