package com.example.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demorest.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}