package com.spring.microservicedemo.auth.services;

import com.spring.microservicedemo.auth.entities.UserRole;

public interface IUserRoleService {

	public UserRole findById(int id);

	public UserRole findByRole(String role);
}
