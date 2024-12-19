package com.spring.microservice.example.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservice.example.employee.entity.Employee;
import com.spring.microservice.example.employee.repository.EmployeeRepository;
import com.spring.microservice.example.employee.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Optional<Employee> findById(int id) {
		return this.employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}

}
