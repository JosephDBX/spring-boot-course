package com.josephdbx.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josephdbx.springbootcourse.dao.UserRepository;
import com.josephdbx.springbootcourse.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostMapping
	public ResponseEntity<?> signUp(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));

		return ResponseEntity.ok(userRepository.save(user));
	}
}
