package com.hqyj.yjxt.system.user.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hqyj.yjxt.frame.utils.dbutils.JdbcUtils;
import com.hqyj.yjxt.system.user.dao.UserDao;
import com.hqyj.yjxt.system.user.model.User;


public class UserDaoImpl implements UserDao {

	@Override
	public User queryUserByUser(User user) {

		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM user WHERE login_name=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getLogin_name());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setName(rs.getString("name"));
				u.setAge(rs.getString("age"));
				u.setSex(rs.getString("sex"));
				u.setHobby(rs.getString("hobby"));
				u.setLogin_name(rs.getString("login_name"));
				u.setPassword(rs.getString("password"));
				// u.setCreate_time(rs.getDate("create_time"));
				return u;
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
