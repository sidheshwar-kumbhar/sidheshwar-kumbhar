package com.redis.cache.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redis.cache.example.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

}
