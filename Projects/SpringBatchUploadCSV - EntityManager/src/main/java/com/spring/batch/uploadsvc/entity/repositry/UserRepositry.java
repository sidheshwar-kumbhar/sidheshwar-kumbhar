package com.spring.batch.uploadsvc.entity.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.uploadsvc.entity.User;

@Repository("userRepositry")
public interface UserRepositry extends CrudRepository<User, Integer>{  
}  