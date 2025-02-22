package com.spring.microservicedemo.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservicedemo.auth.entities.UserRole;
import com.spring.microservicedemo.auth.repositories.UserRoleRepository;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public UserRole findById(int id) {
		return this.userRoleRepository.findById(id);
	}

	@Override
	public UserRole findByRole(String role) {
		return this.userRoleRepository.findByRole(role);
	}
}
