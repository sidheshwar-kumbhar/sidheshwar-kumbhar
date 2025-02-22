package com.spring.microservicedemo.auth.controllers;

import com.spring.microservicedemo.auth.entities.User;
import com.spring.microservicedemo.auth.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/auth/users")
@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/me")
	public ResponseEntity<Optional<User>> authenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Optional<User> currentUser = userService.findByEmail(((User) authentication.getPrincipal()).getUsername());

		return ResponseEntity.ok(currentUser);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')") // Use hasRole for role-based access
	@GetMapping("/list")
	public ResponseEntity<List<User>> allUsers() {
		List<User> users = userService.allUsers();

		return ResponseEntity.ok(users);
	}
}
