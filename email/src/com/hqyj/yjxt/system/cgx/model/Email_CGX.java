package com.hqyj.yjxt.system.cgx.model;
import java.sql.Timestamp;
public class Email_CGX {
	private int cgx_id;
	private int user_id;//该用户的id
	private String cgx_text;
	private Timestamp putcgx_time;
	private int cgx_type;
	private String base;
	public Email_CGX(int cgx_id, int user_id, String cgx_text, Timestamp putcgx_time, int cgx_type, String base) {
		super();
		this.cgx_id = cgx_id;
		this.user_id = user_id;
		this.cgx_text = cgx_text;
		this.putcgx_time = putcgx_time;
		this.cgx_type = cgx_type;
		this.base = base;
	}
	public Email_CGX() {
		super();
	}
	public int getCgx_id() {
		return cgx_id;
	}
	public void setCgx_id(int cgx_id) {
		this.cgx_id = cgx_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCgx_text() {
		return cgx_text;
	}
	public void setCgx_text(String cgx_text) {
		this.cgx_text = cgx_text;
	}
	public Timestamp getPutcgx_time() {
		return putcgx_time;
	}
	public void setPutcgx_time(Timestamp putcgx_time) {
		this.putcgx_time = putcgx_time;
	}
	public int getCgx_type() {
		return cgx_type;
	}
	public void setCgx_type(int cgx_type) {
		this.cgx_type = cgx_type;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	@Override
	public String toString() {
		return "Email_CGX [cgx_id=" + cgx_id + ", user_id=" + user_id + ", cgx_text=" + cgx_text + ", putcgx_time="
				+ putcgx_time + ", cgx_type=" + cgx_type + ", base=" + base + "]";
	}
	
	
}
