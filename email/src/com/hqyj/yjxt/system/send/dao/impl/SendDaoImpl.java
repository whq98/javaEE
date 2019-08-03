package com.hqyj.yjxt.system.send.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hqyj.yjxt.frame.utils.dbutils.JdbcUtils;
import com.hqyj.yjxt.system.cgx.model.Email_CGX;
import com.hqyj.yjxt.system.mail.model.Email;
import com.hqyj.yjxt.system.send.dao.SendDao;
import com.hqyj.yjxt.system.user.model.User;


public class SendDaoImpl implements SendDao {

	@Override
	public User queryUserbyUserName(String rec_login_name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM user WHERE login_name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rec_login_name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setHobby(rs.getString("hobby"));
				user.setLogin_name(rs.getString("login_name"));
				user.setPassword(rs.getString("password"));
				// user.setCreate_time(rs.getDate("create_time"));
				// new Timestamp(new Date().getTime());
				return user;
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addMail(Email mail) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "insert into email(send_login_name,rec_login_name,email_theme,email_text,email_create_time,send_type,rec_type) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mail.getSend_login_name());
			pstmt.setString(2, mail.getRec_login_name());
			pstmt.setString(3, mail.getEmail_theme());
			pstmt.setString(4, mail.getEmail_text());
			pstmt.setTimestamp(5, new Timestamp(new Date().getTime()));
			pstmt.setInt(6, mail.getSend_type());
			pstmt.setInt(7, mail.getRec_type());
			int n = pstmt.executeUpdate();
			return n;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Email> queryAllMailBySendUser_name(String send_login_name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM email where send_login_name=? and send_type=1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, send_login_name);
			ResultSet rs = pstmt.executeQuery();
			List<Email> mailList = new ArrayList<>();
			while (rs.next()) {
				Email mail = new Email();
				mail.setEmail_id(rs.getInt("email_id"));
				mail.setSend_login_name(rs.getString("send_login_name"));
				mail.setRec_login_name(rs.getString("rec_login_name"));
				mail.setEmail_theme(rs.getString("email_theme"));
				mail.setEmail_text(rs.getString("email_text"));
				mail.setEmail_create_time(rs.getTimestamp("email_create_time"));
				mail.setSend_type(rs.getInt("send_type"));
				mail.setRec_type(rs.getInt("rec_type"));
				mailList.add(mail);
			}
			return mailList;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Email queryMailByMailId(int mail_id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM email where email_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mail_id);
			ResultSet rs = pstmt.executeQuery();
			Email mail = new Email();
			while (rs.next()) {
				mail.setEmail_id(rs.getInt("email_id"));
				mail.setSend_login_name(rs.getString("send_login_name"));
				mail.setRec_login_name(rs.getString("rec_login_name"));
				mail.setEmail_theme(rs.getString("email_theme"));
				mail.setEmail_text(rs.getString("email_text"));
				mail.setEmail_create_time(rs.getTimestamp("email_create_time"));
				mail.setSend_type(rs.getInt("send_type"));
				mail.setRec_type(rs.getInt("rec_type"));
			}
			return mail;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteMailByMailId(int mail_id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "UPDATE email SET send_type = ? WHERE email_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, mail_id);
			int n = pstmt.executeUpdate();

			return n;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Email> queryAllDeletedMailBySendUser_name(String sendUser_name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM email where send_login_name=? and send_type=0";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sendUser_name);
			ResultSet rs = pstmt.executeQuery();
			List<Email> mailList = new ArrayList<>();
			while (rs.next()) {
				Email mail = new Email();
				mail.setEmail_id(rs.getInt("email_id"));
				mail.setSend_login_name(rs.getString("send_login_name"));
				mail.setRec_login_name(rs.getString("rec_login_name"));
				mail.setEmail_theme(rs.getString("email_theme"));
				mail.setEmail_text(rs.getString("email_text"));
				mail.setEmail_create_time(rs.getTimestamp("email_create_time"));
				mail.setSend_type(rs.getInt("send_type"));
				mail.setRec_type(rs.getInt("rec_type"));
				mailList.add(mail);
			}
			return mailList;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int thoroughDeleteMailByMailId(int mail_id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "UPDATE email SET send_type = ? WHERE email_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, -1);
			pstmt.setInt(2, mail_id);
			int n = pstmt.executeUpdate();
			return n;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int DeleteInformation(int mail_id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "delete from email where email_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mail_id);
			int n = pstmt.executeUpdate();
			return n;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int recoverMailByMailId(int mail_id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "UPDATE email SET send_type = ? WHERE email_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, mail_id);
			int n = pstmt.executeUpdate();
			return n;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int queryMailTotalRecord() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "SELECT count(*) FROM  mail";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> queryAllUser(String user_name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM user WHERE login_name !=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_name);
			ResultSet rs = pstmt.executeQuery();
			List<User> userList = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setHobby(rs.getString("hobby"));
				user.setLogin_name(rs.getString("login_name"));
				user.setPassword(rs.getString("password"));
				// user.setCreate_time(rs.getDate("create_time"));
				userList.add(user);
			}
			return userList;
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addEmail_CGX(Email_CGX cgx) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "insert into email_cgx(user_id,cgx_text,putcgx_time,cgx_type,base) values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cgx.getUser_id());
			pstmt.setString(2, cgx.getCgx_text());
			pstmt.setTimestamp(3, cgx.getPutcgx_time());
			pstmt.setInt(4, cgx.getCgx_type());
			pstmt.setString(5, cgx.getBase());
			int n = pstmt.executeUpdate();
			return n;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	

}
