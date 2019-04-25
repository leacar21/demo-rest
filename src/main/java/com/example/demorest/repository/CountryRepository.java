package com.example.demorest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demorest.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    public List<Country> findByCode(String code);

}