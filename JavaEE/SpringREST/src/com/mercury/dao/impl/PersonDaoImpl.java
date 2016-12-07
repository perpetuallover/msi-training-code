 package com.mercury.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mercury.beans.Address;
import com.mercury.beans.Person;
import com.mercury.dao.PersonDao;

@Repository
public class PersonDaoImpl implements PersonDao {
	private JdbcTemplate template;
	@Autowired
	public void init(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from emp";
		return template.query(sql, new RowMapper<Person>(){
			@Override
			public Person mapRow(ResultSet rs, int line) throws SQLException {
				// TODO Auto-generated method stub
				Person person = new Person();
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				Address address = new Address();
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				person.setAddress(address);
				return person;
			}		
		});
	}

	@Override
	public Person findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from emp where name=?";
		Object[] params = {name};
		final Person person = new Person();
		template.query(sql, params, new RowMapper<Person>(){
			@Override
			public Person mapRow(ResultSet rs, int line) throws SQLException {
				// TODO Auto-generated method stub
				
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				Address address = new Address();
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				person.setAddress(address);
				return person;
			}		
		});
		return person;
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		String sql = "update emp set city=?, state=?, age=? where name=?";
		Object[] params = {			
				person.getAddress().getCity(),
				person.getAddress().getState(),
				person.getAge(),
				person.getName()
		};
		template.update(sql, params);
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		String sql = "delete emp where name=?";
		Object[] params = {name};
		template.update(sql, params);
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		String sql = "insert into emp values(?,?,?,?)";
		Object[] params = {
				person.getName(),
				person.getAddress().getCity(),
				person.getAddress().getState(),
				person.getAge()
		};
		template.update(sql, params);
	}

}
