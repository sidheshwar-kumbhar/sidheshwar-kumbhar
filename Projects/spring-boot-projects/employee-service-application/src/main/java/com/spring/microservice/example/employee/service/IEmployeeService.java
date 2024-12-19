package com.spring.microservice.example.employee.service;

import java.util.List;
import java.util.Optional;

import com.spring.microservice.example.employee.entity.Employee;

public interface IEmployeeService {

	public Optional<Employee> findById(int id);

	public List<Employee> findAll();

	public Employee save(Employee employee);

}