package com.mercury.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.util.JdbcUtil;

import oracle.jdbc.OracleTypes;

@Repository("hd01")
public class HelloDaoimpl01 implements HelloDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try{
			Connection conn = JdbcUtil.getConnection();
			String sp = "{?=call saveuser(?, ?)}"; //stop processedure
			CallableStatement cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, user.getName());
			cs.setInt(3, user.getAge());
			cs.execute();			
			cs.close();
		} catch(Exception e){
			System.err.println(e);
		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		try{
			Connection conn = JdbcUtil.getConnection();
			String sp2 = "{?=call queryuser()}";
			CallableStatement cs = conn.prepareCall(sp2);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next()){
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			rs.close();
		} catch (Exception e){
			System.err.println(e);
		}
		return list;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
