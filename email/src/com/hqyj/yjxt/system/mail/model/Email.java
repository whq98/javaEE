package com.hqyj.yjxt.system.mail.model;

import java.sql.Timestamp;

public class Email {
	private int email_id;
	private String send_login_name;
	private String rec_login_name;
	private String email_theme;
	private String email_text;
	private Timestamp email_create_time;
	private int send_type;
	private int rec_type;
	public int getEmail_id() {
		return email_id;
	}
	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}
	public String getSend_login_name() {
		return send_login_name;
	}
	public void setSend_login_name(String send_login_name) {
		this.send_login_name = send_login_name;
	}
	public String getRec_login_name() {
		return rec_login_name;
	}
	public void setRec_login_name(String rec_login_name) {
		this.rec_login_name = rec_login_name;
	}
	public String getEmail_theme() {
		return email_theme;
	}
	public void setEmail_theme(String email_theme) {
		this.email_theme = email_theme;
	}
	public String getEmail_text() {
		return email_text;
	}
	public void setEmail_text(String email_text) {
		this.email_text = email_text;
	}
	public Timestamp getEmail_create_time() {
		return email_create_time;
	}
	public void setEmail_create_time(Timestamp email_create_time) {
		this.email_create_time = email_create_time;
	}
	public int getSend_type() {
		return send_type;
	}
	public void setSend_type(int send_type) {
		this.send_type = send_type;
	}
	public int getRec_type() {
		return rec_type;
	}
	public void setRec_type(int rec_type) {
		this.rec_type = rec_type;
	}
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Email(int email_id, String send_login_name, String rec_login_name, String email_theme, String email_text,
			Timestamp email_create_time, int send_type, int rec_type) {
		super();
		this.email_id = email_id;
		this.send_login_name = send_login_name;
		this.rec_login_name = rec_login_name;
		this.email_theme = email_theme;
		this.email_text = email_text;
		this.email_create_time = email_create_time;
		this.send_type = send_type;
		this.rec_type = rec_type;
	}
	@Override
	public String toString() {
		return "Email [email_id=" + email_id + ", send_login_name=" + send_login_name + ", rec_login_name="
				+ rec_login_name + ", email_theme=" + email_theme + ", email_text=" + email_text
				+ ", email_create_time=" + email_create_time + ", send_type=" + send_type + ", rec_type=" + rec_type
				+ "]";
	}
	
	
	
}
