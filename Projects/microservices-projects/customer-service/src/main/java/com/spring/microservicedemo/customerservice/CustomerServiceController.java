package com.spring.microservicedemo.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.microservicedemo.customerservice.bean.Product;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerServiceController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCustomer(@PathVariable int id) {
		ResponseEntity<Product[]> responseEntity = restTemplate
				.getForEntity("http://localhost:8071/productservice/api/v1/product/list", Product[].class);
		HttpStatusCode statusCode = responseEntity.getStatusCode();

		if (statusCode.value() == 200) {
			Product[] productList = responseEntity.getBody();
			return ResponseEntity.ok(productList);
		}

		return ResponseEntity.internalServerError().body("Server error");
	}

}
