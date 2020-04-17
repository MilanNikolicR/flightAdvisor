package com.projects.flightadvirosor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.flightadvirosor.model.User;

public interface UserRepository  extends JpaRepository<User, String> {

	List<String> findRolesByUsername(String username);

	User findByUsername(String username);

}
