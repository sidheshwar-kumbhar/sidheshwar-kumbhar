package com.spring.batch.uploadsvc.config;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.batch.uploadsvc.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserResultRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int i) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setCity(rs.getString("city"));
		user.setContry(rs.getString("contry"));
		user.setState(rs.getString("state"));
		
		return user;
	}
}
