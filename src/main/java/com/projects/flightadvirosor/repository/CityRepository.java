package com.projects.flightadvirosor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.flightadvirosor.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

	City findByName(String name);
}
