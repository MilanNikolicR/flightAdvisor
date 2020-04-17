package com.projects.flightadvirosor.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comment")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id", nullable = false)
	Integer commentId;
	@Column(name = "description", nullable = false)
	String description;
	@Column(name = "created_date", nullable = false)
	Date createdDate;
	@Column(name = "modified_date", nullable = false)
	Date modifiedDate;
	@Column(name = "username", nullable = false)
	String username;
	
}
