package com.ozh.identity.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.ozh.identity.dao.UserDao;
import com.ozh.identity.dao.impl.UserDaoImpl;
import com.ozh.identity.datamodel.User;
import com.ozh.identity.util.ConnectionFactory;

public class CheckUserService {
	private UserDao userDao = new UserDaoImpl();
	
	public boolean check(User user){
		Connection conn = null;
		
		try {

			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet = userDao.get(conn, user);
			System.out.println(resultSet);
			while ( resultSet.next()) {
//				System.out.println(resultSet.getString("address"));
				return true;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
}
