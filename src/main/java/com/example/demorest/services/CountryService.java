package com.example.demorest.services;

import java.util.List;

import com.example.demorest.model.Country;

public interface CountryService {

    public void createCountry(Country country);

    public Country getCountry(String countryCode);

    public List<Country> getCountries();
}
