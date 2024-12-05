package com.microservice.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/first-service")
public class FirstController {
	@GetMapping(value = "/message/{name}")
	public ResponseEntity<?> getMessage(@PathVariable String name) {
		return ResponseEntity.ok(new MessageResponse("Hell " + name + " from first service !"));
	}
}