package com.spring.microservicedemo.auth.dtos;

import java.util.List;

import com.spring.microservicedemo.auth.entities.Address;
import com.spring.microservicedemo.auth.entities.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {

	private String email;
	private String password;
	private String fullName;
	private UserRole role;
	private List<Address> addresses;

}