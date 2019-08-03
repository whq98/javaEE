package com.hqyj.yjxt.system.user.service.impl;

import com.hqyj.yjxt.system.user.dao.UserDao;
import com.hqyj.yjxt.system.user.dao.impl.UserDaoImpl;
import com.hqyj.yjxt.system.user.model.User;
import com.hqyj.yjxt.system.user.service.UserService;


public class UserServiceImpl implements UserService {
	// 实例化：数据模型层接口
	UserDao userDao = new UserDaoImpl();
	
	
	@Override
	public User queryUserByLogin_nameAndPassword(String login_name, String password) {
		User user = new User();
		user.setLogin_name(login_name);
		user.setPassword(password);
		// System.out.println("---------------UserServiceImpl----------" +
		// user);
		User u = userDao.queryUserByUser(user);
		return u;
	}


	

}
