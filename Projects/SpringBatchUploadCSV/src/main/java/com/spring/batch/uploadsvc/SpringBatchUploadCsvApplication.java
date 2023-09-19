package com.spring.batch.uploadsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.spring.batch.uploadsvc")
@EntityScan("com.spring.batch.uploadsvc")
@AutoConfigurationPackage(basePackages = { "com.spring.batch.uploadsvc" })
@SpringBootApplication
public class SpringBatchUploadCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchUploadCsvApplication.class, args);
	}

}
