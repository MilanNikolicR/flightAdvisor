package com.projects.flightadvirosor.dto;

import java.util.List;

import com.projects.flightadvirosor.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;	
	private List<Role> roles;
}
