package com.hqyj.yjxt.system.user.service;


import com.hqyj.yjxt.system.user.model.User;


public interface UserService {

	User queryUserByLogin_nameAndPassword(String login_name, String password);
}
