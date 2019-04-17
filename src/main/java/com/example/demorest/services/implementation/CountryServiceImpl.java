package com.example.demorest.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demorest.model.Country;
import com.example.demorest.repository.CountryRepository;
import com.example.demorest.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public void createCountry(Country country) {
		countryRepository.save(country);
	}

	@Override
	public Country getCountry(String code) {
		List<Country> listCountry = countryRepository.findByCode(code);
		Optional<Country> optionalCountry = listCountry.stream().findFirst();
		return optionalCountry.orElse(null);
	}

}
