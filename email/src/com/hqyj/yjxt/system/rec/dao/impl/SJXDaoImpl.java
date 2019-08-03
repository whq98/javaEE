package com.hqyj.yjxt.system.rec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hqyj.yjxt.frame.utils.dbutils.JdbcUtils;
import com.hqyj.yjxt.system.mail.model.Email;
import com.hqyj.yjxt.system.rec.dao.SJXDao;

public class SJXDaoImpl implements SJXDao {
	Connection conn = null;
	/**
	 * 查询收件箱所有邮件
	 */
	@Override
	public List<Email> queryAllSJXEmailByLogin_name(String login_name) {
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from email where rec_login_name=? and rec_type=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, login_name);
			prep.setInt(2, 1);
			ResultSet rs = prep.executeQuery();
			List<Email> emailList = new ArrayList<>();
			while (rs.next()) {
				Email email = new Email();
				email.setEmail_id(rs.getInt("email_id"));
				email.setSend_login_name(rs.getString("send_login_name"));
				email.setRec_login_name(rs.getString("rec_login_name"));
				email.setEmail_theme(rs.getString("email_theme"));
				String text = rs.getString("email_text");
				if (text.length() > 21) {
					email.setEmail_text(text.substring(0, 21));
				} else {
					email.setEmail_text(text);
				}
				email.setEmail_create_time(rs.getTimestamp("email_create_time"));
				email.setSend_type(rs.getInt("send_type"));
				email.setRec_type(rs.getInt("rec_type"));
				emailList.add(email);
			}
			return emailList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过邮件id删除邮件
	 */
	@Override
	public int deleteByEmail_i(int email_id) {
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update email set rec_type=rec_type-1 where email_id=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, email_id);
			int n = prep.executeUpdate();
			return n;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 通过邮件id查询邮件
	 */
	@Override
	public Email selectByEmail_id(int email_id) {
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from email where email_id=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, email_id);
			ResultSet rs = prep.executeQuery();
			Email email = new Email();
			while (rs.next()) {

				email.setEmail_id(rs.getInt("email_id"));
				email.setSend_login_name(rs.getString("send_login_name"));
				email.setRec_login_name(rs.getString("rec_login_name"));
				email.setEmail_theme(rs.getString("email_theme"));
				email.setEmail_text(rs.getString("email_text"));
				email.setEmail_create_time(rs.getTimestamp("email_create_time"));
				email.setSend_type(rs.getInt("send_type"));
				email.setRec_type(rs.getInt("rec_type"));

			}
			return email;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询所有收件箱回收站邮件
	 */
	@Override
	public List<Email> queryAllRecBinEmail(String login_name) {
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from email where rec_login_name=? and rec_type=0";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, login_name);
			ResultSet rs = prep.executeQuery();
			List<Email> emailList = new ArrayList<>();
			while (rs.next()) {
				Email email = new Email();
				email.setEmail_id(rs.getInt("email_id"));
				email.setSend_login_name(rs.getString("send_login_name"));
				email.setRec_login_name(rs.getString("rec_login_name"));
				email.setEmail_theme(rs.getString("email_theme"));
				String text = rs.getString("email_text");
				if (text.length() > 21) {
					email.setEmail_text(text.substring(0, 21));
				} else {
					email.setEmail_text(text);
				}
				email.setEmail_create_time(rs.getTimestamp("email_create_time"));
				email.setSend_type(rs.getInt("send_type"));
				email.setRec_type(rs.getInt("rec_type"));
				emailList.add(email);
			}
			return emailList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 从数据库删除邮件
	 */
	@Override
	public int realDeleteByEmail_id(int email_id) {
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from email where email_id=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, email_id);
			int n = prep.executeUpdate();
			return n;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 收件箱恢复邮件
	 */
	@Override
	public int recoveryEmailByEmail_id(int email_id) {
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update email set rec_type=1 where email_id=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, email_id);
			int n = prep.executeUpdate();
			return n;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
