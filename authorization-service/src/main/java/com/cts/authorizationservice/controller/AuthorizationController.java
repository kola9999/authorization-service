package com.cts.authorizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorizationservice.entity.UserCredential;
import com.cts.authorizationservice.service.UserDetailsServiceImpl;
import com.cts.authorizationservice.util.JwtUtil;

@RestController
public class AuthorizationController {

	@Autowired
	private UserDetailsServiceImpl service;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestHeader("Authorization") String token) {
		token = token.substring(7);
		try {
			UserDetails user = service.loadUserByUsername(jwtUtil.extractUsername(token));
			if (jwtUtil.validateToken(token, user)) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} else {
				return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/login")
	public String getUser(@RequestBody UserCredential userCredential) {
		UserDetails user = service.loadUserByUsername(userCredential.getUserName());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (user.getUsername().equals(userCredential.getUserName())
				&& encoder.matches(userCredential.getPassword(), user.getPassword())) {
			return jwtUtil.generateToken(userCredential.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid credentials");
		}
	}

}
