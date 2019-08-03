package com.hqyj.yjxt.system.rec.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hqyj.yjxt.frame.controller.BaseController;
import com.hqyj.yjxt.system.mail.model.Email;
import com.hqyj.yjxt.system.rec.service.SJXService;
import com.hqyj.yjxt.system.rec.service.impl.SJXServiceImpl;
import com.hqyj.yjxt.system.user.model.User;


public class SJXController extends BaseController {

	/** serialVersionUID */
	private static final long serialVersionUID = 8683090688796567658L;

	SJXService sjxService = new SJXServiceImpl();

	/**
	 * <p>
	 * 跳转到收件箱界面
	 * </p>
	 * 
	 * @author tangxin
	 * @Date 2019年7月11日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("USER");
//		System.out.println("getEmail-----"+user);
		List<Email> emailList = sjxService.queryAllSJXEmailByLogin_name(user.getLogin_name());
		req.setAttribute("emailList", emailList);
		return "view/system/sjx/sjxbegin.jsp";
	}

	/**
	 * <p>
	 * 收件箱删除
	 * </p>
	 * 
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idstr = req.getParameter("email_id");
		int email_id = Integer.parseInt(idstr);
		int n = sjxService.deleteByEmail_id(email_id);

		if (n != 0) {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("USER");
			List<Email> emailList = sjxService.queryAllSJXEmailByLogin_name(user.getLogin_name());
			req.setAttribute("emailList", emailList);
			req.setAttribute("message", "删除成功！");
		}
		return "view/system/sjx/sjxbegin.jsp";
	}

	/**
	 * <p>
	 * 收件箱批量删除
	 * </p>
	 * 
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deletes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idstrs[] = req.getParameterValues("id[]");
		for (String idstr : idstrs) {
			int email_id = Integer.valueOf(idstr);
			sjxService.deleteByEmail_id(email_id);
		}

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("USER");
		System.out.println(user);
		List<Email> emailList = sjxService.queryAllSJXEmailByLogin_name(user.getLogin_name());
		req.setAttribute("emailList", emailList);
		req.setAttribute("message", "删除成功！");
		return "view/system/sjx/sjxbegin.jsp";
	}

	/**
	 * <p>
	 * 查看收件详细内容
	 * </p>
	 * 
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String selectUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取查看邮件id
		String email_idstr = req.getParameter("email_id");
		int email_id = Integer.valueOf(email_idstr);
		// 调用业务
		Email email = sjxService.selectByEmail_id(email_id);
		req.setAttribute("email", email);
		// 跳转页面
		return "view/system/sjx/select.jsp";
	}

	/**
	 * <p>
	 * 获取回复收件人
	 * </p>
	 * 
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String replyUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取查看邮件id
		String email_idstr = req.getParameter("email_id");
		int email_id = Integer.valueOf(email_idstr);
		// 调用业务
		Email email = sjxService.selectByEmail_id(email_id);
		req.setAttribute("email", email);
		// 跳转页面
		return "view/system/sjx/reply.jsp";
	}

	/**
	 * <p>
	 * 回复（调用发件函数）
	 * </p>
	 * 
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String reply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return this.getEmail(req, resp);
	}

	/**
	 * <p>
	 * 收件回收站页面
	 * </p>
	 * 
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getBinEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("USER");
		List<Email> emailList = sjxService.queryAllRecBinEmail(user.getLogin_name());
		req.setAttribute("emailList", emailList);
		return "view/system/sjx/bin.jsp";
	}
	public String deepDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idstr=req.getParameter("email_id");
		int email_id=Integer.parseInt(idstr);
		Email email = sjxService.selectByEmail_id(email_id);
		if (email.getSend_type()==-1) {
			sjxService.realDeleteByEmail_id(email_id);
		} else {
			sjxService.deleteByEmail_id(email_id);
		}
		return this.getBinEmail(req, resp);
	}
	public String deepDeletes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idstrs[] = req.getParameterValues("id[]");
		for (String idstr : idstrs) {
			int email_id = Integer.valueOf(idstr);
			Email email = sjxService.selectByEmail_id(email_id);
			if (email.getSend_type()==-1) {
				sjxService.realDeleteByEmail_id(email_id);
			} else {
				sjxService.deleteByEmail_id(email_id);
			}
		}
		return this.getBinEmail(req, resp);
	}
	
	/**
	 * <p>
	 * 查看回收箱邮件详细信息
	 * </p>
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String lookbin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取查看邮件id
		String email_idstr = req.getParameter("email_id");
		int email_id = Integer.valueOf(email_idstr);
		// 调用业务
		Email email = sjxService.selectByEmail_id(email_id);
		req.setAttribute("email", email);
		// 跳转页面
		return "view/system/sjx/lookbin.jsp";
	}
	
	/**
	 * <p>
	 * 从垃圾箱还原邮件
	 * </p>
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String recoveryEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取查看邮件id
		String email_idstr = req.getParameter("email_id");
		int email_id = Integer.valueOf(email_idstr);
		// 调用业务
		sjxService.recoveryEmailByEmail_id(email_id);
		// 跳转页面
		return this.getBinEmail(req, resp);
	}
	
	/**
	 * <p>
	 * 获取转发页面内容
	 * </p>
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String transmitUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取查看邮件id
		String email_idstr = req.getParameter("email_id");
		int email_id = Integer.valueOf(email_idstr);
		// 调用业务
		Email email = sjxService.selectByEmail_id(email_id);
		req.setAttribute("email", email);
		// 跳转页面
		return "view/system/sjx/transmit.jsp";
	}
	/**
	 * <p>
	 * 转发邮件（调用发件函数）
	 * </p>
	 * @author tangxin
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String transmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取查看邮件id
//		Email email = new Email();
//		String send_login_name = req.getParameter("send_login_name");
//		String rec_login_name = req.getParameter("rec_login_name");
//		String email_theme = req.getParameter("email_theme");
//		String email_text = req.getParameter("email_text");
//		email.setSend_login_name(send_login_name);
//		email.setRec_login_name(rec_login_name);
//		email.setEmail_theme(email_theme);
//		email.setEmail_text(email_text);
//		email.setEmail_create_time(new Timestamp(new Date().getTime()));
//		email.setSend_type(1);
//		email.setRec_type(1);
//		// 调用业务
//		// 跳转页面
//		 req.setAttribute("email", email);
//		 resp.sendRedirect("redirect:view/system/send/send.jsp");
		return this.getEmail(req, resp);
	}
	
}
