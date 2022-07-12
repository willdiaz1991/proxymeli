package com.co.meli.serviceproxy.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.co.meli.serviceproxy.dto.PetitionDTO;
import com.co.meli.serviceproxy.repository.PetitionRepository;

@Service
public class PetitionsService implements IPetitionsService {

	@Autowired
	private PetitionRepository petitionRepository;
	
	@Value("${api.count.limit}")
    private int apiCountLimit;
	
	@Value("${api.count.timelimit}")
    private long apiTimeLimit;
	
	
	@Value("${api.count.standbytime}")
    private long apiStandbyLimit;
	
	@Override
	public boolean savePetition(String id) {

		PetitionDTO petitionDTO = new PetitionDTO();
		petitionDTO.setId(id);	
		try {
			petitionDTO = petitionRepository.findById(id);
			petitionDTO.setPeticiones(petitionDTO.getPeticiones() + 1);
			petitionDTO.setExecutionDate(new Date().getTime());
		} catch (Exception e) {
			petitionDTO = new PetitionDTO();
			petitionDTO.setId(id);	
			petitionDTO.setPeticiones(1);
			petitionDTO.setStartDate(new Date().getTime());
		}
		if (petitionDTO.getPeticiones()>1) {
			if (petitionDTO.getPeticiones() > apiCountLimit && (petitionDTO.getExecutionDate() - petitionDTO.getStartDate() < apiTimeLimit)) {
				long standbyTime = new Date().getTime();
				if (standbyTime - petitionDTO.getExecutionDate() > apiStandbyLimit) {
					petitionRepository.delete(id);
				}
				System.out.println("#############################################################");
				System.out.println("#              peticion rechazada                           #");
				System.out.println("#Peticion: " + id +"                                        #");
				System.out.println("#numero de peticion: " + petitionDTO.getPeticiones());
				System.out.println("#                                                           #");
				System.out.println("#############################################################");
				return false;
			}
		}
		
		if (petitionDTO.getExecutionDate() - petitionDTO.getStartDate() > apiTimeLimit) {
			petitionDTO.setPeticiones(1);
			petitionDTO.setStartDate(new Date().getTime());
		}
		
		try {
			petitionRepository.save(petitionDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PetitionDTO responsepetitionDTO = petitionRepository.findById(id);
		System.out.println("#############################################################");
		System.out.println("#              Peticion aceptada                            #");
		System.out.println("#Peticion: " + id +"                                        #");
		System.out.println("#numero de peticion: " + responsepetitionDTO.getPeticiones());
		System.out.println("#                                                           #");
		System.out.println("#############################################################");
		return true;
	}

}
