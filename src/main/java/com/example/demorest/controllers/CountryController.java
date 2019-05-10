package com.example.demorest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorest.model.Country;
import com.example.demorest.services.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/{code}")
    public Country findByCode(@PathVariable("code") String code) {
        return this.countryService.getCountry(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Country country) {
        // throw new RuntimeException("mensaje");
        this.countryService.createCountry(country);
    }

}
