package com.example.demorest.services;

import com.example.demorest.model.Country;

public interface CountryService {
	
	public void createCountry(Country country);
	
	public Country getCountry(String countryCode);
	
}
