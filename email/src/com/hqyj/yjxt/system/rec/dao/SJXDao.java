package com.hqyj.yjxt.system.rec.dao;

import java.util.List;

import com.hqyj.yjxt.system.mail.model.Email;


public interface SJXDao {

	List<Email> queryAllSJXEmailByLogin_name(String login_name);

	int deleteByEmail_i(int email_id);

	Email selectByEmail_id(int email_id);

	List<Email> queryAllRecBinEmail(String login_name);

	int realDeleteByEmail_id(int email_id);

	int recoveryEmailByEmail_id(int email_id);
}
