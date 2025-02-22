package com.spring.microservicedemo.auth.services;

import java.util.List;
import java.util.Optional;

import com.spring.microservicedemo.auth.entities.User;

public interface IUserService {

	public List<User> allUsers();

	public Optional<User> findById(int id);

	public Optional<User> findByEmail(String email);
}
