package com.spring.microservices.demo.auth.services;

import org.springframework.stereotype.Service;

import com.spring.microservices.demo.auth.entities.User;
import com.spring.microservices.demo.auth.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements IUserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> allUsers() {
		List<User> users = new ArrayList<>();

		userRepository.findAll().forEach(users::add);

		return users;
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
}