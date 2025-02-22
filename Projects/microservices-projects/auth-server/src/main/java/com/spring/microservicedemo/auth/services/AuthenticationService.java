package com.spring.microservicedemo.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.microservicedemo.auth.dtos.LoginUserDto;
import com.spring.microservicedemo.auth.dtos.RegisterUserDto;
import com.spring.microservicedemo.auth.entities.User;
import com.spring.microservicedemo.auth.repositories.UserRepository;

@Service
public class AuthenticationService {
	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final IUserRoleService userRoleService;

	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder, IUserRoleService userRoleService) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userRoleService = userRoleService;
	}

	public User signup(RegisterUserDto input) {
		User user = new User();
		user.setFullName(input.getFullName());
		user.setEmail(input.getEmail());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		user.setRole(this.userRoleService.findById(input.getRole().getId()));
		user.setAddresses(input.getAddresses());

		return userRepository.save(user);
	}

	public User authenticate(LoginUserDto input) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
		if (!authentication.isAuthenticated()) {
			throw new UsernameNotFoundException("User not found");
		}
		return userRepository.findByEmail(input.getEmail()).orElseThrow();

	}
}