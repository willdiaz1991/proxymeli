package com.co.meli.serviceproxy.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.meli.serviceproxy.dto.StatisticalDTO;
import com.co.meli.serviceproxy.repository.StatisticalRepository;

@Service
public class StatiscticalService implements IStatisticalService {

	@Autowired
	private StatisticalRepository statisticalRepository;
	
	@Override
	public void statisticalPetitionsMeli(StatisticalDTO data,boolean isCorrect) {
		StatisticalDTO statisticalDTO = statisticalRepository.findById(data.getIp());
		if (statisticalDTO == null) {
			statisticalDTO = new StatisticalDTO();
			statisticalDTO.setIp(data.getIp());
			statisticalDTO.setIdCategorie(data.getIdCategorie());
			statisticalDTO.setDescription(data.getDescription());
			if (isCorrect) {
				statisticalDTO.setCoutPetition(1);
				statisticalDTO.setCoutPetitionCancelled(0);
			}else {
				statisticalDTO.setCoutPetition(0);
				statisticalDTO.setCoutPetitionCancelled(1);
			}
		} else {
			if (isCorrect) {
				statisticalDTO.setCoutPetition(statisticalDTO.getCoutPetition() + 1);
			}else {
				statisticalDTO.setCoutPetitionCancelled(statisticalDTO.getCoutPetitionCancelled() + 1);
			}
		}
		System.out.println("#############################################################");
		System.out.println("#              peticion guarda en estadistico               #");
		System.out.println("#Peticion: " + statisticalDTO.getIp() + statisticalDTO.getIdCategorie() +"                                        #");
		System.out.println("#numero de peticion: " + statisticalDTO.getCoutPetition());
		System.out.println("#numero de canceladas : " + statisticalDTO.getCoutPetitionCancelled());
		System.out.println("#                                                           #");
		System.out.println("#############################################################");
		statisticalRepository.save(statisticalDTO);
	}

	@Override
	public Map<String, StatisticalDTO> statisticalallPetitions() {
		return statisticalRepository.findAll();
	}

}
