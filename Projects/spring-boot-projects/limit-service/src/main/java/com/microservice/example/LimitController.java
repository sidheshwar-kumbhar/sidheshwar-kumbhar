package com.microservice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class LimitController {

	@Autowired
	private Configuration configuration;

	@GetMapping(value = "/limits")
	public ResponseEntity<?> getMessage() {
		return ResponseEntity.ok(new Limits(configuration.getMinimum(), configuration.getMaximum()));
	}
}
