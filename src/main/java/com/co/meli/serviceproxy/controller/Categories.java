package com.co.meli.serviceproxy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.meli.serviceproxy.dto.StatisticalDTO;
import com.co.meli.serviceproxy.service.CategoriesService;
import com.co.meli.serviceproxy.service.PetitionsService;
import com.co.meli.serviceproxy.service.StatiscticalService;

@RestController
public class Categories {
	
	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private PetitionsService petitionsService;
	
	@Autowired
	private StatiscticalService statiscticalService;
	
	
	@GetMapping("/categorie")
	public ResponseEntity<HashMap<String, String>> categorie (@RequestParam String id, HttpServletRequest request){
		//CategoriesService categoriesService = new CategoriesService();
		StatisticalDTO statisticalDTO = new StatisticalDTO();
		statisticalDTO.setIdCategorie(id);
		statisticalDTO.setIp(request.getRemoteAddr());
		
		if (petitionsService.savePetition(request.getRemoteAddr()) && petitionsService.savePetition(id)) {
			statiscticalService.statisticalPetitionsMeli(statisticalDTO,true);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(categoriesService.categoriesMeli(id));
		} else {
			statisticalDTO.setDescription("cantidad maxima de peticiones sobrepasada");
			statiscticalService.statisticalPetitionsMeli(statisticalDTO,false);
			HashMap<String, String> response = new HashMap<String, String>();
			response.put("message", "cantidad maxima de peticiones sobrepasada");
			response.put("status", HttpStatus.FORBIDDEN.toString());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).contentType(MediaType.APPLICATION_JSON).body(response);
		}		
	}
	
	@GetMapping("/statistical")
	public ResponseEntity<Map<String, StatisticalDTO>> statistical(){
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(statiscticalService.statisticalallPetitions());
	}
	

}
