package com.co.meli.serviceproxy.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.co.meli.serviceproxy.client.MeliClient;

@Service
public class CategoriesService implements ICategoriesService{

	
	@Override
	public HashMap<String, String> categoriesMeli(String id){
		MeliClient clientCategorie = new MeliClient();
		
		HashMap<String, String> categories = clientCategorie.clientCategoriesMeli(id);
		return categories;
	}

}
