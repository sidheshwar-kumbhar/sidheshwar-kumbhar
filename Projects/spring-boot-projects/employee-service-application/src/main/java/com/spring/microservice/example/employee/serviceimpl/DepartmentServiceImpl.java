package com.spring.microservice.example.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservice.example.employee.entity.Department;
import com.spring.microservice.example.employee.repository.DepartmentRepository;
import com.spring.microservice.example.employee.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Optional<Department> findById(int id) {
		return this.departmentRepository.findById(id);
	}

	@Override
	public List<Department> findAll() {
		return this.departmentRepository.findAll();
	}

	@Override
	public Department save(Department department) {
		return this.departmentRepository.save(department);
	}

	@Override
	public Optional<Department> findByName(String name) {
		return this.departmentRepository.findByName(name);
	}

}
