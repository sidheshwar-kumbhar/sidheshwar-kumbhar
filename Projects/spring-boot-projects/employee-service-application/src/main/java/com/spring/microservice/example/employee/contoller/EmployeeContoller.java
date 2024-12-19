package com.spring.microservice.example.employee.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.example.employee.entity.Employee;
import com.spring.microservice.example.employee.service.IDepartmentService;
import com.spring.microservice.example.employee.service.IEmployeeService;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeContoller {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IDepartmentService departmentService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployById(@PathVariable int id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		
		employee.setDepartment(departmentService.findByName(employee.getDepartment().getName()).get());
		return ResponseEntity.ok(this.employeeService.save(employee));
	}

}
