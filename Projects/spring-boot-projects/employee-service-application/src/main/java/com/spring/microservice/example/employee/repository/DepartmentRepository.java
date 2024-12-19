package com.spring.microservice.example.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservice.example.employee.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Optional<Department> findByName(String name);

}
