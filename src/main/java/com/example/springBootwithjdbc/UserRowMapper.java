package com.example.springBootwithjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;



public class UserRowMapper implements org.springframework.jdbc.core.RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		return user;
	}
	

	
}
