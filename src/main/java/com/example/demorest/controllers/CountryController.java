package com.example.demorest.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.demorest.services.implementation.UserServiceImpl;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/{code}")
    public Country findByCode(@PathVariable("code") String code) {
        return this.countryService.getCountry(code);
    }

    @GetMapping()
    public List<Country> getAll() {
        return this.countryService.getCountries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Country country) {
        this.countryService.createCountry(country);
    }

    @PostMapping(value = "/async")
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<Void> createAsync(@RequestBody Country country) {
        LOGGER.info("Create Async started");
        var cfuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }

            this.countryService.createCountry(country);
        });
        LOGGER.info("Create Async released");

        return cfuture;
    }

}