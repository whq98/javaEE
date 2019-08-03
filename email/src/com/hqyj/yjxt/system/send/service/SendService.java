package com.hqyj.yjxt.system.send.service;

import java.util.List;

import com.hqyj.yjxt.system.cgx.model.Email_CGX;
import com.hqyj.yjxt.system.mail.model.Email;
import com.hqyj.yjxt.system.user.model.User;


public interface SendService {

	User queryUserbyUserNmae(String rec_login_name);

	int addMail(Email mail);

	List<Email> queryAllMailBySendUser_name(String send_login_name);

	Email queryMailByMailId(int mail_id);

	int deleteMailByMailId(int mail_id);

	List<Email> queryAllDeletedMailBySendUser_name(String sendUser_name);

	int thoroughDeleteMailByMailId(int mail_id);

	int DeleteInformation(int mail_id);

	int recoverMailByMailId(int mail_id);

	List<User> queryAllUser(String user_name);

	int addEmail_CGX(Email_CGX cgx);


}
