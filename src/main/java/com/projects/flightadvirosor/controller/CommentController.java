package com.projects.flightadvirosor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projects.flightadvirosor.dto.CommentDto;
import com.projects.flightadvirosor.service.CommentService;

public class CommentController {

	@Autowired
    private CommentService service;
	 
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/addComment", method = RequestMethod.POST)
    public ResponseEntity<String> addComment(@RequestBody CommentDto dto){
        return service.addComment(dto);
    }
    
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/deleteComment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteComment(@PathVariable("id") Integer id){
        return service.deleteComment(id);
    }
    
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/updateComment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateComment(@PathVariable("id") Integer id, @RequestBody CommentDto dto){
    	return service.updateComment(id,dto);
    }
   
	
}
