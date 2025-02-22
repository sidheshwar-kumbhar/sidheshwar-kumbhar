package com.spring.microservicedemo.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservicedemo.auth.entities.UserRole;

@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	public UserRole findById(int id);

	public UserRole findByRole(String role);

}
