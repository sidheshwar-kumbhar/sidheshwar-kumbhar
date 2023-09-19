package com.spring.batch.uploadsvc.entity.repositry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.spring.batch.uploadsvc.entity.User;

@Service("customUserRepository")
public class CustomUserRepositoryImpl implements ICustomUserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public User customFindMethod(int id) {
		return (User) entityManager.createQuery("FROM User WHERE id = :id").setParameter("id", id)
				.getSingleResult();
	}

}
