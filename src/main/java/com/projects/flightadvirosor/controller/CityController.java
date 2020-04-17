package com.projects.flightadvirosor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projects.flightadvirosor.dto.CityDto;
import com.projects.flightadvirosor.model.City;
import com.projects.flightadvirosor.service.CityService;

@RestController
public class CityController {

	 @Autowired
	 private CityService service;
	 
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/addCity", method = RequestMethod.POST)
    public ResponseEntity<String> addCity(@RequestBody CityDto city){
        return service.setCity(city);
    }
    
    
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/getAllCities", method = RequestMethod.GET)
    public ResponseEntity<List<City>> getAllCities(){
        return service.getAllCities();
    }
	
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/getCityByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<City> getCityByName(@PathVariable(value = "name") String name){
        return service.getCityByName(name);
    }
    
}
