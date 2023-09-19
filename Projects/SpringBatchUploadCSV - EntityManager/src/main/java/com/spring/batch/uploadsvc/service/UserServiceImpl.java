package com.spring.batch.uploadsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.batch.uploadsvc.entity.User;
import com.spring.batch.uploadsvc.entity.repositry.ICustomUserRepository;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private ICustomUserRepository customUserRepository;

	@Override
	public User customFindMethod(int id) {
		return customUserRepository.customFindMethod(id);
	}
	

}
