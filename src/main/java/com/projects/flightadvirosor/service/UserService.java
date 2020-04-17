package com.projects.flightadvirosor.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.projects.flightadvirosor.model.User;
import com.projects.flightadvirosor.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
			
	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set getAuthority(User user) {
        Set authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

	public List<String> getUserRoles(String username) {
		return userRepository.findRolesByUsername(username);
	}
	
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

    public ResponseEntity<String> save(User user) {
		try {
			userRepository.save(user);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
		}
    }

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public ResponseEntity<String> delete(String username) {
		User u = userRepository.findByUsername(username);
		userRepository.delete(u);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	public boolean checkPassForms(String username, String pass) {
		User u = userRepository.findByUsername(username);
		try {
			if (BCrypt.checkpw(pass.toString(), u.getPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}
}