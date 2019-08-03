package com.hqyj.yjxt.system.rec.service;

import java.util.List;

import com.hqyj.yjxt.system.mail.model.Email;


public interface SJXService {

	List<Email> queryAllSJXEmailByLogin_name(String login_name);

	int deleteByEmail_id(int email_id);

	Email selectByEmail_id(int email_id);

	List<Email> queryAllRecBinEmail(String login_name);

	int realDeleteByEmail_id(int email_id);

	int recoveryEmailByEmail_id(int email_id);

}
