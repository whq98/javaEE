package com.hqyj.yjxt.system.send.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hqyj.yjxt.frame.controller.BaseController;
import com.hqyj.yjxt.system.cgx.model.Email_CGX;
import com.hqyj.yjxt.system.mail.model.Email;
import com.hqyj.yjxt.system.send.service.SendService;
import com.hqyj.yjxt.system.send.service.impl.SendServiceImpl;
import com.hqyj.yjxt.system.user.model.User;
import com.hqyj.yjxt.system.user.service.UserService;
import com.hqyj.yjxt.system.user.service.impl.UserServiceImpl;


public class SendController extends BaseController {

	/**  */
	private static final long serialVersionUID = 3129994352794464655L;
	SendService sendService = new SendServiceImpl();
	UserService userservice=new UserServiceImpl();

	// 1.进入发送邮件界面页面
	public String sendMailUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 2、跳转页面
		return "view/system/send/send.jsp";
	}
	// 2.发送邮件
	public String sendMail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		// 收件人ID
		String rec_login_name = req.getParameter("rec_login_name");
		// 查看是否有此收件人
		User recUser = sendService.queryUserbyUserNmae(rec_login_name);
		if (recUser == null) {
			req.setAttribute("message", "发送失败，查无此人！");
			// 2.跳转页面
			return "view/system/send/send.jsp";
		} else {
			// 1.接收数据
			// 发件人登录名
			String sendUser_name = req.getParameter("sendUser_name");
			// 邮件主题
			String email_theme = req.getParameter("email_theme");
			// 邮件内容
			String email_text = req.getParameter("email_text");

			Email mail = new Email();
			mail.setSend_login_name(sendUser_name);
			mail.setRec_login_name(rec_login_name);
			mail.setEmail_theme(email_theme);
			mail.setEmail_text(email_text);
			mail.setEmail_create_time(new Timestamp(new Date().getTime()));
			mail.setSend_type(1);
			mail.setRec_type(1);
			// 增加到邮件表中
			int n = sendService.addMail(mail);
			req.setAttribute("message", "发送成功,是否继续发送?");
			// 2.跳转页面
			return "view/system/send/success.jsp";
		}
	}

	// 3.进入发件箱页面
	public String OutBox(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		String send_login_name = req.getParameter("login_name");
		
		// 3、调用业务
		// 2.查询所有的收件
		List<Email> mailList = sendService.queryAllMailBySendUser_name(send_login_name);
		req.setAttribute("mailList", mailList);
		return "view/system/send/outbox/outbox.jsp";
	}

	// 4.查看发送成功的邮件
	public String queryMail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		String mail_idStr = req.getParameter("mail_id");
		int mail_id = Integer.parseInt(mail_idStr);
		// 2.查看收件
		Email mail = sendService.queryMailByMailId(mail_id);
		req.setAttribute("mail", mail);
		return "view/system/send/outbox/looktext.jsp";
	}

	// 5.删除发送成功的邮件
	public String deleteMail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		String sendUser_name = req.getParameter("user_name");
		String mail_idStr = req.getParameter("mail_id");
		int mail_id = Integer.parseInt(mail_idStr);
		// 3.删除邮件通过邮件id
		int n = sendService.deleteMailByMailId(mail_id);

		// 2.查询所有的收件
		List<Email> mailList = sendService.queryAllMailBySendUser_name(sendUser_name);
		req.setAttribute("mailList", mailList);
		return "view/system/send/outbox/outbox.jsp";
	}

	// 6.查看已删除的邮件
	public String queryDeletedMail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1、接受数据
		String sendUser_name = req.getParameter("user_name");

		// 3.查询所有的收件
		List<Email> mailList = sendService.queryAllDeletedMailBySendUser_name(sendUser_name);
		req.setAttribute("mailList", mailList);
		// 2.跳转页面
		return "view/system/send/Deleted/Deleted.jsp";
	}

	// 7.彻底删除发送成功的邮件
	public String thoroughdeleteMail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1、接受数据
		String sendUser_name = req.getParameter("user_name");

		String mail_idStr = req.getParameter("mail_id");
		int mail_id = Integer.parseInt(mail_idStr);
		// 3.彻底删除邮件
		int n = sendService.thoroughDeleteMailByMailId(mail_id);
		// 判断邮件是否收发两方都彻底删除邮件,如果是,则彻底删除

		Email mail = sendService.queryMailByMailId(mail_id);
		if ((mail.getRec_type() == -1) && (mail.getSend_type() == -1)) {
			int m = sendService.DeleteInformation(mail_id);
		}

		// 3.查询所有的收件
		List<Email> mailList = sendService.queryAllDeletedMailBySendUser_name(sendUser_name);
		req.setAttribute("mailList", mailList);
		// 2.跳转页面
		return "view/system/send/Deleted/Deleted.jsp";
	}

	// 8.批量删除
	public String PLDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		String[] ids = req.getParameterValues("id[]");
		// 1、接受数据
		String sendUser_name = req.getParameter("user_name");
		for (String mail_idStr : ids) {
			// 3、调用业务
			if (mail_idStr.equals("")) {

			} else {
				int mail_id = Integer.parseInt(mail_idStr);
				int n = sendService.deleteMailByMailId(mail_id);
			}
		}

		// 2.查询所有的收件
		List<Email> mailList = sendService.queryAllMailBySendUser_name(sendUser_name);
		req.setAttribute("mailList", mailList);
		return "view/system/send/outbox/outbox.jsp";

	}

	// 9.彻底批量删除
	public String thoroughPLDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1、接受数据
		String[] ids = req.getParameterValues("id[]");
		// 1、接受数据
		String sendUser_name = req.getParameter("user_name");
		for (String mail_idStr : ids) {
			// 3、调用业务
			if (mail_idStr.equals("")) {

			} else {
				int mail_id = Integer.parseInt(mail_idStr);
				int n = sendService.thoroughDeleteMailByMailId(mail_id);
				Email mail = sendService.queryMailByMailId(mail_id);
				if ((mail.getRec_type() == -1) && (mail.getSend_type() == -1)) {
					int m = sendService.DeleteInformation(mail_id);
				}
			}
		}

		// 2.查询所有的收件
		List<Email> mailList = sendService.queryAllDeletedMailBySendUser_name(sendUser_name);
		req.setAttribute("mailList", mailList);
		return "view/system/send/Deleted/Deleted.jsp";

	}

	// 10.恢复邮件
	public String recoverMail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		String sendUser_name = req.getParameter("user_name");
		String mail_idStr = req.getParameter("mail_id");
		int mail_id = Integer.parseInt(mail_idStr);
		// 3.恢复邮件
		int n = sendService.recoverMailByMailId(mail_id);

		// 3.查询所有的收件
		List<Email> mailList = sendService.queryAllDeletedMailBySendUser_name(sendUser_name);
		req.setAttribute("mailList", mailList);
		// 2.跳转页面
		return "view/system/send/Deleted/Deleted.jsp";

	}
	//11.群发UI
	public String qfUI(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1、接受数据
		String user_name = req.getParameter("user_name");
		// 2.查询所有的用户
		List<User> userList = sendService.queryAllUser(user_name);

		req.setAttribute("userList", userList);
		return "view/system/send/qunfa.jsp";
	}
	/**群发*/
	public String qf(HttpServletRequest req, HttpServletResponse resp) {	
		//接收数据	
		//发件人姓名
		String sendUser_name = req.getParameter("sendUser_name");
		// 邮件主题
		String email_theme = req.getParameter("email_theme");
		// 邮件内容
		String email_text = req.getParameter("email_text");
		
		//收件人数组
		String [] recUser_names = req.getParameterValues("recUser_name[]");

		//调用业务
		//循环发送
//		List<User> userSelected=userservice.queryUsers
//		List<String> selectedNames=new ArrayList();
//		List<Menu> menuSelected = menuservice.querySelectedMenuListByRole_id(role_id);
//		List<String> list = new ArrayList<String>();
//		for (User mm : userSelected) {
//			list.add(mm.getLogin_name());
//		}
		for(String rec_login_name : recUser_names){
			if(rec_login_name.equals("")){
				
			}else{			
				Email mail = new Email();
				mail.setSend_login_name(sendUser_name);
				mail.setRec_login_name(rec_login_name);
				mail.setEmail_theme(email_theme);
				mail.setEmail_text(email_text);
				mail.setEmail_create_time(new Timestamp(new Date().getTime()));
				mail.setSend_type(1);
				mail.setRec_type(1);
				// 增加到邮件表中
				int n = sendService.addMail(mail);
			}
		}
//		req.setAttribute("selectedNames", selectedNames);
		req.setAttribute("message", "发送成功");
		//跳转页面
		return "view/system/send/qunfa.jsp";
	}
	/** 存入草稿箱 */
	public String CGX(HttpServletRequest req, HttpServletResponse resp) {
		// 1、接受数据
		// 发件人登录名
		String user_idStr = req.getParameter("user_id");
		int user_id = Integer.parseInt(user_idStr);
		// 邮件主题
		String email_theme = req.getParameter("email_theme");
		// 邮件内容
		String email_text = req.getParameter("email_text");
		Email_CGX cgx = new Email_CGX();
		cgx.setUser_id(user_id);
		cgx.setCgx_text(email_text);
		cgx.setPutcgx_time(new Timestamp(new Date().getTime()));
		cgx.setCgx_type(1);
		cgx.setBase(email_theme);
		// 增加到邮件表中
		int n = sendService.addEmail_CGX(cgx);
		req.setAttribute("message", "存储成功");
		// 2.跳转页面
		return "view/system/send/CGX.jsp";

	}
}
