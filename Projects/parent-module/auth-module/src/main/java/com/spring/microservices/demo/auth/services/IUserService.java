package com.spring.microservices.demo.auth.services;

import java.util.List;
import java.util.Optional;

import com.spring.microservices.demo.auth.entities.User;

public interface IUserService {

	public List<User> allUsers();

	public Optional<User> findById(int id);
}
