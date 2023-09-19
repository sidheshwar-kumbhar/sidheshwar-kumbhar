package com.spring.batch.uploadsvc.entity.repositry;

import org.springframework.data.repository.CrudRepository;
import com.spring.batch.uploadsvc.entity.User;

public interface UserRepositry extends CrudRepository<User, Integer> {  
}  