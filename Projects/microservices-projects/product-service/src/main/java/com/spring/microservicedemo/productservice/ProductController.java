package com.spring.microservicedemo.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list() {
		List<Product> productList = new ArrayList<>();
		
		productList.add(new Product(1, "Pen"));
		productList.add(new Product(2, "Book"));
		
		return ResponseEntity.ok(productList);
	}
}
