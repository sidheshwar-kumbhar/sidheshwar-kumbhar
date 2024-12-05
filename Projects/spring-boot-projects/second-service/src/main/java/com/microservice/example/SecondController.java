package com.microservice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/v1/second-service")
public class SecondController {
	
	@Autowired
	private RestTemplate restTrmplate;

	@GetMapping(value = "/message/{name}")
	public ResponseEntity<?> getMessage(@PathVariable String name) {

		MessageResponse message = restTrmplate
				.getForObject("http://api-gateway/first-service/api/v1/first-service/message/" + name,
				MessageResponse.class);

		return ResponseEntity.ok(new MessageResponse("Hell " + name + " from second service! " + message.getMessage()));
	}
}