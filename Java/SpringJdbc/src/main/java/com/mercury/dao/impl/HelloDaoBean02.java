package com.mercury.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

public class HelloDaoBean02 implements HelloDao{
	private JdbcTemplate template;
	/*public void setDataSource(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}*/
	@Autowired
	public void init(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Object[] params = {user.getName(), user.getAge()};
		String sql = "insert into Sample values(?,?)";
		template.update(sql, params);
	}

	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		String sql = "select * from Sample";
		return template.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int line)throws SQLException{
				User user = new User();
				user.setName(rs.getString("Name"));
				user.setAge(rs.getInt("Age"));
				return user;
			}
		});			
	}

	@Override
	public void delete(User user) {		
		// TODO Auto-generated method stub
		Object[] params = {user.getName(), user.getAge()};
		String sql = "delete Sample where Name=? and Age=?";
		template.update(sql, params);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Object[] params = {user.getAge(), user.getName()};
		String sql = "update Sample set Age=? where Name=?";
		template.update(sql, params);
	}
}
