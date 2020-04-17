package com.projects.flightadvirosor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.flightadvirosor.dto.LoginDTO;
import com.projects.flightadvirosor.model.AuthToken;
import com.projects.flightadvirosor.model.User;
import com.projects.flightadvirosor.security.JwtTokenUtil;
import com.projects.flightadvirosor.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginUser) throws AuthenticationException {
		User user = userService.findByUsername(loginUser.getUsername());
		if (loginUser.getUsername().equals("") || user == null) {
			return new ResponseEntity<>("No user found with username '%s'." + loginUser.getUsername(),
					HttpStatus.NOT_FOUND);
		}
		try {
				if (userService.checkPassForms(loginUser.getUsername(), loginUser.getPassword())) {
					final Authentication authentication = authenticationManager.authenticate(
							new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
					SecurityContextHolder.getContext().setAuthentication(authentication);
					if (loginUser.getUsername().equals("")) {
						throw new UsernameNotFoundException(
								String.format("No user found with username '%s'.", loginUser.getUsername()));
					}
					final User user2 = userService.findByUsername(loginUser.getUsername());
					final String salt = jwtTokenUtil.generateToken(user2);
					user2.setSalt(salt);
					userService.save(user2);
					return ResponseEntity.ok(new AuthToken(salt));
				} else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			
		}

}
