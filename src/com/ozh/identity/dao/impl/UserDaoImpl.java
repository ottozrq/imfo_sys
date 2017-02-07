package com.ozh.identity.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.ozh.identity.dao.UserDao;
import com.ozh.identity.datamodel.User;

public class UserDaoImpl implements UserDao{
	
	@Override
	public ResultSet read(Connection conn, User user) throws SQLException {
		if (user == null) {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareCall("select * from tbl_user");
			return ps.executeQuery();
		}
		PreparedStatement ps = (PreparedStatement) conn
				.prepareCall("select * from tbl_user where id = ?");

		ps.setInt(1, user.getId());
		return ps.executeQuery();
	}
	
	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn
				.prepareCall("insert into tbl_user(displayname, name, password, email, address) values (?,?,?,?,?)");
//		System.out.println(user.getName());
		ps.setString(1, user.getDisplayname());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getAddress());
		ps.execute();
		
	}

	@Override
	public void update(Connection conn, User user) throws SQLException {
		String updateSql = "update tbl_user set displayname=?,name = ?, password=?, email = ?, address = ? where id = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(updateSql);

		ps.setString(1, user.getDisplayname());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getAddress());
		ps.setInt(6, user.getId());
		ps.execute();
		
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("delete from tbl_user where id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
		
	}

	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from tbl_user where name = ? AND password = ?");
		ps.setString(1, user.getName());
//		System.out.println(user.getName());
		ps.setString(2, user.getPassword());
//		System.out.println(user.getPassword());
		return ps.executeQuery();
	}


}
