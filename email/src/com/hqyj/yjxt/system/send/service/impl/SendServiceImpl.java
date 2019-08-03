package com.hqyj.yjxt.system.send.service.impl;

import java.util.List;

import com.hqyj.yjxt.system.cgx.model.Email_CGX;
import com.hqyj.yjxt.system.mail.model.Email;
import com.hqyj.yjxt.system.send.dao.SendDao;
import com.hqyj.yjxt.system.send.dao.impl.SendDaoImpl;
import com.hqyj.yjxt.system.send.service.SendService;
import com.hqyj.yjxt.system.user.model.User;


public class SendServiceImpl implements SendService{
	SendDao sendDao = new SendDaoImpl();

	@Override
	public int addMail(Email mail) {
		// TODO Auto-generated method stub
		return sendDao.addMail(mail);
	}
	@Override
	public List<Email> queryAllMailBySendUser_name(String send_login_name) {
		// TODO Auto-generated method stub
		return sendDao.queryAllMailBySendUser_name(send_login_name);
	}
	@Override
	public User queryUserbyUserNmae(String rec_login_name) {
		// TODO Auto-generated method stub
		return sendDao.queryUserbyUserName(rec_login_name);
	}
	@Override
	public Email queryMailByMailId(int mail_id) {
		// TODO Auto-generated method stub
		return sendDao.queryMailByMailId(mail_id);
	}
	@Override
	public int deleteMailByMailId(int mail_id) {
		// TODO Auto-generated method stub
		return sendDao.deleteMailByMailId(mail_id);
	}
	@Override
	public List<Email> queryAllDeletedMailBySendUser_name(String sendUser_name) {
		// TODO Auto-generated method stub
		return sendDao.queryAllDeletedMailBySendUser_name(sendUser_name);
	}
	@Override
	public int thoroughDeleteMailByMailId(int mail_id) {
		// TODO Auto-generated method stub
		return sendDao.thoroughDeleteMailByMailId(mail_id);
	}
	@Override
	public int DeleteInformation(int mail_id) {
		// TODO Auto-generated method stub
		return sendDao.DeleteInformation(mail_id);
	}
	@Override
	public int recoverMailByMailId(int mail_id) {
		// TODO Auto-generated method stub
		return sendDao.recoverMailByMailId(mail_id);
	}
	@Override
	public List<User> queryAllUser(String user_name) {
		// TODO Auto-generated method stub
		return sendDao.queryAllUser(user_name);
	}
	@Override
	public int addEmail_CGX(Email_CGX cgx) {
		// TODO Auto-generated method stub
		return sendDao.addEmail_CGX(cgx);
	}


}
