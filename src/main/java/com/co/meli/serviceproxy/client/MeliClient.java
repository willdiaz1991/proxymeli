package com.co.meli.serviceproxy.client;

import java.util.HashMap;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class MeliClient {
	
	public HashMap<String, String> clientCategoriesMeli(String id) {
		HashMap<String, String> categories = new HashMap<String, String>();
		try {       
            RestTemplate restTemplate = new RestTemplate();
            categories =  restTemplate.getForObject("https://api.mercadolibre.com/categories/" + id, HashMap.class);
            System.out.println(categories);
            return categories;
		}catch(HttpClientErrorException hce) {
			categories.put("message", "Category " + hce.getStatusText() + ": " + id);
			categories.put("error", hce.getStatusText());
			categories.put("status", hce.getStatusCode().toString());
			return categories;
        } catch (Exception e) {
            System.out.println("Exception in clientCategoriesMeli:- " + e);
            categories.put("error", e.getMessage());
            return categories;
        }
	}

}
