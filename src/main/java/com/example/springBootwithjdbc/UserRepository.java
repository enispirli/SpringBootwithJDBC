package com.example.springBootwithjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<User>findAll(){
		return jdbcTemplate.query("select * from users", new UserRowMapper());
		}
	
	public User findUserById(int id) {
		return jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{id},new UserRowMapper());
		
	}
	
    public User create(final User user) {
    	final String sql="insert into users(name,email) values(?,?)";
    	KeyHolder holder=new GeneratedKeyHolder();
    	jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				 PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				 ps.setString(1, user.getName());
				 ps.setString(2, user.getEmail());
				 return ps;
			}
		},holder );
    	 
    	int newUserId=holder.getKey().intValue();
    	user.setId(newUserId);
    	return user;
    	
    }
    public void delete(int id) {
    	final String sql="delete from users where id=?";
    	jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps=con.prepareStatement(sql); 
				ps.setInt(1, id);
				return ps;	
			}
		});
    }
    
    public void update(User user ) {
    	final String sql="update users set name=?, email=? where id=?";
    	jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setInt(3, user.getId());
				return ps;
			}
		});
    	
    }
}
