package com.hqyj.yjxt.system.cgx.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hqyj.yjxt.frame.utils.dbutils.JdbcUtils;
import com.hqyj.yjxt.system.cgx.dao.CGXDao;
import com.hqyj.yjxt.system.cgx.model.Email_CGX;

public class CGXDaoImpl implements CGXDao {
	@Override
	public List<Email_CGX> queryAllCGX() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			conn=JdbcUtils.getConnection();
			String sql = "SELECT * FROM  cgx";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Email_CGX> CGXList = new ArrayList<Email_CGX>();
			while(rs.next()) {
				Email_CGX email_CGX = new Email_CGX();
				email_CGX.setCgx_id(rs.getInt("cgx_id"));
				//得到内容
				String contextStr=rs.getString("cgx_text");
				String base=contextStr.substring(0,3);
				email_CGX.setBase(base);
				email_CGX.setCgx_text(rs.getString("cgx_text"));
				email_CGX.setCgx_type(rs.getInt("cgx_type"));
			     Timestamp timestamp=rs.getTimestamp("putcgx_time");
				email_CGX.setPutcgx_time(timestamp);
				email_CGX.setUser_id(rs.getInt("user_id"));
				CGXList.add(email_CGX);
			}
			System.out.println(CGXList);
			return CGXList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteCGXByCGX_id(int cgx_id) {
		Connection  conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "DELETE FROM cgx WHERE cgx_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cgx_id);
			int m = pstmt.executeUpdate();
			return m;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Email_CGX queryCgxByCgx_id(int cgx_id) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			conn=JdbcUtils.getConnection();
			String sql = "SELECT * FROM  cgx where cgx_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cgx_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Email_CGX email_CGX = new Email_CGX();
				email_CGX.setCgx_id(rs.getInt("cgx_id"));
				//得到内容
				String contextStr=rs.getString("cgx_text");
				String base=contextStr.substring(0,3);
				email_CGX.setBase(base);
				email_CGX.setCgx_text(rs.getString("cgx_text"));
				email_CGX.setCgx_type(rs.getInt("cgx_type"));
			     Timestamp timestamp=rs.getTimestamp("putcgx_time");
				email_CGX.setPutcgx_time(timestamp);
				email_CGX.setUser_id(rs.getInt("user_id"));
				return email_CGX;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int updateTextByCgx_id(Email_CGX ec) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		try {
			conn=JdbcUtils.getConnection();
			String sql = "update cgx set cgx_text=? where cgx_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ec.getCgx_text());
			pstmt.setInt(2,ec.getCgx_id());
			int m=pstmt.executeUpdate();
			return m;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int queryAllCount() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rSet=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql = "select count(*) from cgx";
			pstmt = conn.prepareStatement(sql);
			rSet=pstmt.executeQuery();
			if(rSet.next()) {
				int count=rSet.getInt(1);
				return count;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Email_CGX> queryUserBycount(int i, int page_size) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<Email_CGX> list=new ArrayList<Email_CGX>();
		try {
			conn=JdbcUtils.getConnection();
			String sql = "SELECT * FROM  cgx limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,i);
			pstmt.setInt(2,page_size);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Email_CGX email_CGX = new Email_CGX();
				email_CGX.setCgx_id(rs.getInt("cgx_id"));
				//得到内容
				String contextStr=rs.getString("cgx_text");
				String base=contextStr.substring(0,2);
				email_CGX.setBase(base);
				email_CGX.setCgx_text(rs.getString("cgx_text"));
				email_CGX.setCgx_type(rs.getInt("cgx_type"));
			     Timestamp timestamp=rs.getTimestamp("putcgx_time");
				email_CGX.setPutcgx_time(timestamp);
				email_CGX.setUser_id(rs.getInt("user_id"));
				list.add(email_CGX);
			}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int checkTypeByType(int type,int cgx_id) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		try {
			conn=JdbcUtils.getConnection();
			String sql = "update cgx set cgx_type=? where cgx_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,type);
			pstmt.setInt(2,cgx_id);
			int m=pstmt.executeUpdate();
			return m;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
