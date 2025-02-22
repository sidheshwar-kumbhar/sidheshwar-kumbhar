package com.spring.microservicedemo.auth.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservicedemo.auth.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);

	Optional<User> findById(int id);

	List<User> findAll();
}
