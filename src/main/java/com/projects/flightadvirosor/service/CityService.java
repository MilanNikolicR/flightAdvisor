package com.projects.flightadvirosor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.flightadvirosor.dto.CityDto;
import com.projects.flightadvirosor.model.City;
import com.projects.flightadvirosor.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;
	
	public ResponseEntity<List<City>> getAllCities() {
		List<City>  cities = repo.findAll();
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}

	public ResponseEntity<City> getCityByName(String name) {
		City  city = repo.findByName(name);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}

	public ResponseEntity<String> setCity(CityDto city) {
		try{
			City  c = new City();
			c.setCountry(city.getCountry());
			c.setDescription(city.getDescription());
			c.setName(city.getName());
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
		}
	}


}
