package com.hqyj.yjxt.system.rec.service.impl;

import java.util.List;

import com.hqyj.yjxt.system.mail.model.Email;
import com.hqyj.yjxt.system.rec.dao.SJXDao;
import com.hqyj.yjxt.system.rec.dao.impl.SJXDaoImpl;
import com.hqyj.yjxt.system.rec.service.SJXService;


public class SJXServiceImpl implements SJXService {

	SJXDao sjxDao = new SJXDaoImpl();

	@Override
	public List<Email> queryAllSJXEmailByLogin_name(String login_name) {
		return sjxDao.queryAllSJXEmailByLogin_name(login_name);
	}

	@Override
	public int deleteByEmail_id(int email_id) {
		return sjxDao.deleteByEmail_i(email_id);
	}

	@Override
	public Email selectByEmail_id(int email_id) {

		return sjxDao.selectByEmail_id(email_id);
	}

	@Override
	public List<Email> queryAllRecBinEmail(String login_name) {
		return sjxDao.queryAllRecBinEmail(login_name);
	}

	@Override
	public int realDeleteByEmail_id(int email_id) {
		return sjxDao.realDeleteByEmail_id(email_id);
	}

	@Override
	public int recoveryEmailByEmail_id(int email_id) {

		return sjxDao.recoveryEmailByEmail_id(email_id);
	}

}
