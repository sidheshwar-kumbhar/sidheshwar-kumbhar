package com.spring.microservice.example.employee.service;

import java.util.List;
import java.util.Optional;

import com.spring.microservice.example.employee.entity.Department;

public interface IDepartmentService {

	public Optional<Department> findById(int id);

	public Optional<Department> findByName(String name);

	public List<Department> findAll();

	public Department save(Department department);

}
