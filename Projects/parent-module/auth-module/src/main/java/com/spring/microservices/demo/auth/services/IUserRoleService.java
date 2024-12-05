package com.spring.microservices.demo.auth.services;

import com.spring.microservices.demo.auth.entities.UserRole;

public interface IUserRoleService {

	public UserRole findById(int id);

	public UserRole findByRole(String role);
}
