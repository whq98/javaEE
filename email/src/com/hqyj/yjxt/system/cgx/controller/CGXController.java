package com.hqyj.yjxt.system.cgx.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hqyj.yjxt.frame.controller.BaseController;
import com.hqyj.yjxt.frame.model.Page;
import com.hqyj.yjxt.system.cgx.model.Email_CGX;
import com.hqyj.yjxt.system.cgx.service.CGXService;
import com.hqyj.yjxt.system.cgx.service.impl.CGXServiceImpl;
import com.hqyj.yjxt.system.mail.model.Email;
	
public class CGXController extends BaseController{
	/**  */
	private static final long serialVersionUID = 1L;
	CGXService cgxService = new CGXServiceImpl();
	/**
	 * <p>
	 * 直接查詢所有的草稿
	 * </p>
	 * @author zk
	 * @Date 2019年7月11日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		// 3、调用业务
		List<Email_CGX> cgxlist= cgxService.queryAllCGX();
		// 返回数据
		req.setAttribute("cgxlist", cgxlist);
		// 2、跳转页面
		return "view/system/cgx/cgx.jsp";
	}
	/**
	 * <p>
	 * 删除草稿
	 * </p>	
	 * @Copyright (C),华清远见
	 * @author zk
	 * @Date:2019年7月11日
	 */
	public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		String cgx_idstr = req.getParameter("cgx_id");
		int cgx_id = Integer.parseInt(cgx_idstr);
		//System.out.println(cgx_id);
		int n = cgxService.deleteCGXByCGX_id(cgx_id);
		// 3、调用业务
		//再次查詢数据庫，返回数据
		 List<Email_CGX> cgxlist = cgxService.queryAllCGX();
 	     req.setAttribute("cgxlist",cgxlist);
 		return "view/system/cgx/cgx.jsp";
	}
	
	public String updateUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		String cgx_idstr = req.getParameter("cgx_id");
		int cgx_id = Integer.parseInt(cgx_idstr);
		//System.out.println(cgx_id);
		Email_CGX ec=cgxService.queryCgxByCgx_id(cgx_id);
		System.out.println(ec+"-------------");
		req.setAttribute("ec",ec);
		//  System.out.println(cgxlist);
	     return "view/system/cgx/cgxupdate.jsp";
	}
	
	public String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接受数据
		  String cgx_text=req.getParameter("cgx_text");
		  String cgx_idstr=req.getParameter("cgx_id");
		  
		  int cgx_id = Integer.parseInt(cgx_idstr);
		  
		  Email_CGX ec = new Email_CGX();
		  if (cgx_idstr.equals("")) {
			
		}else {
			ec.setCgx_text(cgx_text);
			ec.setCgx_id(cgx_id);
		}
		 // System.out.println(cgx_id);
		  int m=cgxService.updateTextByCgx_id(ec);
//		  System.out.println(m);
		  
		  
		  
		  
		// 再次查询数据库// 返回数据
		 Email_CGX ec1  = cgxService.queryCgxByCgx_id(cgx_id);
		 req.setAttribute("ec",ec1);
			req.setAttribute("msg","修改成功");
	      return "view/system/cgx/cgxupdate.jsp";
	}
	
	
	/**
	 * 
	 * <p>
	 * 
	 * </p>
	 * @author zk
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String PLdelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受数据
		String ids [] = req.getParameterValues("id[]");
		for(String cgx_idstr:ids) {
//			System.out.println("-------PLdelete--------"+role_idstr);
			//调用业务
			if(cgx_idstr.equals("")) {
				//不做这个业务
			}else {
				int cgx_id = Integer.parseInt(cgx_idstr);
				int n = cgxService.deleteCGXByCGX_id(cgx_id);
			}
		}
		// 再次查询数据库// 返回数据
					List<Email_CGX> cgxList = cgxService.queryAllCGX();
					req.setAttribute("cgxlist", cgxList);
					req.setAttribute("msg","修改成功");
			      return "view/system/cgx/cgx.jsp";
	}
	
	/**
	 * 分页的实现
	 * <p>
	 * 
	 * </p>
	 * @author zk
	 * @Date 2019年7月12日
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String pagelist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String nowpagestr=req.getParameter("nowpage"); 
		 int nowpage=0;
		 if(nowpagestr==null||nowpagestr.trim().isEmpty()) 
		 {
			 nowpage=1; 
		 }else{
			    System.out.println("nowpage="+nowpagestr);
		        nowpage=Integer.parseInt(nowpagestr); 
	     } 
		 int page_size=3; 
		 Page beanPage=cgxService.pageList(nowpage,page_size);
		 req.setAttribute("pb",beanPage);
		 return "view/system/cgx/cgx.jsp";
	}
	
	/**
	 * <p>
	 * 
	   * 转发的实现
	 * </p>
	 * @author zk
	 * @Date 2019年7月12日
	 * @param request
	 * @param response
	 * @return
	 */
	public String resend(HttpServletRequest request,HttpServletResponse response) {
		String cgx_idstr=request.getParameter("cgx_id");
		int cgx_id=Integer.parseInt(cgx_idstr);
		Email_CGX ec = cgxService.queryCgxByCgx_id(cgx_id);
		Email email=new Email();
		//insert into email(send_login_name,rec_login_name,email_theme,email_text,email_create_time,send_type,rec_type) values(?,?,?,?,?,?,?)
		email.setEmail_text(ec.getCgx_text());
		email.setEmail_theme(ec.getBase());
		//得到的是本邮件的状态
		int type=ec.getCgx_type();
		//直接将状态变为1
		type=1;
		//需要修改状态
		int m=cgxService.checkTypeByType(type,cgx_id);
		request.setAttribute("email",email);
		//这里直接调用发送的方法，但是email的数据不全，需要加入其它的email需要的数据
        return "";
	}
	
	
}
