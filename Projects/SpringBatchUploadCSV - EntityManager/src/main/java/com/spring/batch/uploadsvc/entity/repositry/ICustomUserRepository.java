package com.spring.batch.uploadsvc.entity.repositry;

import com.spring.batch.uploadsvc.entity.User;

public interface ICustomUserRepository {
	public User customFindMethod(int id);
}
