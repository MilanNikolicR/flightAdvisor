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

import com.projects.flightadvirosor.dto.UserDto;
import com.projects.flightadvirosor.model.User;
import com.projects.flightadvirosor.security.Crypt;
import com.projects.flightadvirosor.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }


    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody UserDto user){
    	User u = new User();
    	u.setFirstname(user.getFirstName());
    	u.setLastname(user.getLastName());
    	u.setUsername(user.getUsername());
    	u.setPassword(Crypt.hashPassword(user.getPassword()));
        return userService.save(u);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value = "id") String id){
        userService.delete(id);
        return null;
    }

}