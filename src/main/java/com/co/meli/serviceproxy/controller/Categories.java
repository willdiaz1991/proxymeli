package com.co.meli.serviceproxy.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.meli.serviceproxy.service.CategoriesService;

@RestController
public class Categories {
	
	@GetMapping("/categorie")
	public HashMap<String, String> categorie (@RequestParam String id){
		return CategoriesService.categoriesMeli(id);
	}

}
