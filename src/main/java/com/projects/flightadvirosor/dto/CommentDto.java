package com.projects.flightadvirosor.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
	
	int commentId;
	String description;
	Date createdDate;
	Date modifiedDate;
	String username;

}
