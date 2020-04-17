package com.projects.flightadvirosor.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projects.flightadvirosor.dto.CommentDto;
import com.projects.flightadvirosor.model.Comment;
import com.projects.flightadvirosor.repository.CommentRepository;

@Service
public class CommentService {

	 @Autowired
	 private CommentRepository repo;
	
	public ResponseEntity<String> addComment(CommentDto dto) {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Comment c = new Comment();
			c.setCreatedDate(dto.getCreatedDate());
			c.setDescription(dto.getDescription());
			c.setModifiedDate(dto.getModifiedDate());
			c.setUsername(auth.getPrincipal().toString());
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> deleteComment(Integer id) {
		try {
			Comment c = repo.findByCommentId(id);
			repo.delete(c);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
		}
		
	}

	public ResponseEntity<String> updateComment(Integer id, CommentDto dto) {
		try {
		 	Comment currentComment = repo.findByCommentId(id);
		 	BeanUtils.copyProperties(dto, currentComment);
		 	repo.save(currentComment);
		 	return new ResponseEntity<String>("Success", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
		}
	}

}
