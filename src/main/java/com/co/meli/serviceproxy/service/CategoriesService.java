package com.co.meli.serviceproxy.service;

import java.util.HashMap;

import com.co.meli.serviceproxy.client.MeliClient;

public class CategoriesService {
	
	public static HashMap<String, String> categoriesMeli(String id){
		MeliClient clientCategorie = new MeliClient();
		HashMap<String, String> categories = clientCategorie.clientCategoriesMeli(id);
		return categories;
	}

}
