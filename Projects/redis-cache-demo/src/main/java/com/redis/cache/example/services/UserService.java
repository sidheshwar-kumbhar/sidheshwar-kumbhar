package com.redis.cache.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.cache.example.models.User;
import com.redis.cache.example.repository.UserRepository;

@Service("userService")
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User getUser(int id) {
		return this.userRepository.findById(id).get();
	}

	public List<User> list() {
		return this.userRepository.findAll();
	}

	public User save(User user) {
		return this.userRepository.save(user);
	}

	public boolean deleteById(int id) {
		this.userRepository.deleteById(id);
		return true;
	}

}
