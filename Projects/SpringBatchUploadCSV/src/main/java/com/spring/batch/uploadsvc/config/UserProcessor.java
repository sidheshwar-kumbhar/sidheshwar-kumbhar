package com.spring.batch.uploadsvc.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.uploadsvc.entity.User;

public class UserProcessor implements ItemProcessor<User, User>{

	@Override
	public User process(User user) throws Exception {
		return user;
	}

}
