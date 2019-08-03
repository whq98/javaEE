package com.hqyj.yjxt.system.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hqyj.yjxt.frame.controller.BaseController;
import com.hqyj.yjxt.system.user.model.User;
import com.hqyj.yjxt.system.user.service.UserService;
import com.hqyj.yjxt.system.user.service.impl.UserServiceImpl;


/**
 * <p>
 * 
 * </p>
 * 
 * @Copyright (C),华清远见
 * @author wmc
 * @Date:2019年7月5日
 */
public class UserController extends BaseController {

	/**  */
	private static final long serialVersionUID = 6418611421228371401L;
	UserService userService = new UserServiceImpl();

	// 1、登录
	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.接收数据
		String login_name = req.getParameter("login_name");
		String password = req.getParameter("password");
		// 3.调用业务
		User user = userService.queryUserByLogin_nameAndPassword(login_name, password);
		if (user == null) {
			// 2.跳转页面
			req.setAttribute("message", "SB，输错啦");
			return "login.jsp";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("USER", user);
			// 2.跳转页面
			return "view/main/main.jsp";
		}

	}

}
