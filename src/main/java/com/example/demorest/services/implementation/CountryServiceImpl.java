package com.example.demorest.services.implementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demorest.exceptions.ForbiddenException;
import com.example.demorest.model.Country;
import com.example.demorest.repository.CountryRepository;
import com.example.demorest.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void createCountry(Country country) {
        LOGGER.info("Saving country: " + country.getCode());

        if (!this.countryRepository.findByCode(country.getCode()).isEmpty()) {
            LOGGER.info("Saving country: " + "There is already a country with the same Code on the database");
            throw new ForbiddenException("There is already a country with the same Code on the database");
        }

        this.countryRepository.save(country);
        LOGGER.info("Saved country: " + country.getCode());
    }

    @Override
    public Country getCountry(String code) {
        LOGGER.info("getCountry country: " + code);
        List<Country> listCountry = this.countryRepository.findByCode(code);
        Optional<Country> optionalCountry = listCountry.stream().findFirst();
        return optionalCountry.orElse(null);
    }

    @Override
    public List<Country> getCountries() {
        LOGGER.info("getCountries");
        return this.countryRepository.findAll();
    }

}
