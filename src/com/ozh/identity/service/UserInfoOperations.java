package com.ozh.identity.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.ozh.identity.dao.UserDao;
import com.ozh.identity.dao.impl.UserDaoImpl;
import com.ozh.identity.datamodel.User;
import com.ozh.identity.util.ConnectionFactory;

public class UserInfoOperations {
	private UserDao userDao = new UserDaoImpl();
	Connection conn = null;
	
	public ResultSet userInfoRead(User user){
		
		try {

			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet = userDao.read(conn, user);
//			System.out.println(resultSet);
			if (resultSet.next()){
				return resultSet;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void userInfoUpdate(User user){
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
//			conn.setAutoCommit(false);
			
			userDao.update(conn, user);
//			System.out.println(user.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void userInfoSave(User user){
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
//			conn.setAutoCommit(false);
			
			userDao.save(conn, user);
//			System.out.println(user.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void userInfoDelete(User user){
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
//			conn.setAutoCommit(false);
			
			userDao.delete(conn, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void conClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
