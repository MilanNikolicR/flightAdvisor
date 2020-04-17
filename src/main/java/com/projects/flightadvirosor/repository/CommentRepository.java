package com.projects.flightadvirosor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.flightadvirosor.model.Comment;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {

	Comment findByCommentId(Integer id);	
}
