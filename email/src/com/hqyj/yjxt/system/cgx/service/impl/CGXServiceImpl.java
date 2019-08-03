package com.hqyj.yjxt.system.cgx.service.impl;

import java.util.List;

import com.hqyj.yjxt.frame.model.Page;
import com.hqyj.yjxt.system.cgx.dao.CGXDao;
import com.hqyj.yjxt.system.cgx.dao.impl.CGXDaoImpl;
import com.hqyj.yjxt.system.cgx.model.Email_CGX;
import com.hqyj.yjxt.system.cgx.service.CGXService;

public class CGXServiceImpl implements CGXService {
	CGXDao cgxDao = new CGXDaoImpl();
	@Override
	public List<Email_CGX> queryAllCGX() {
		return cgxDao.queryAllCGX();
	}
	@Override
	public int deleteCGXByCGX_id(int cgx_id) {
		return cgxDao.deleteCGXByCGX_id(cgx_id);
	}
	@Override
	public Email_CGX queryCgxByCgx_id(int cgx_id) {
		return cgxDao.queryCgxByCgx_id(cgx_id);
	}
	@Override
	public int updateTextByCgx_id(Email_CGX ec) {
		return cgxDao.updateTextByCgx_id(ec);
	}
	@Override
	public Page pageList(int nowpage, int page_size) {
		Page pagebean=new Page();
		pagebean.setNowpage(nowpage);
		pagebean.setPage_size(page_size);
		//来查询数据中数据的个数
		int total_record=cgxDao.queryAllCount();
		//System.out.println("total_record="+total_record);
		pagebean.setTotal_record(total_record);
		System.out.println("pagebean.getTotalpagesize="+pagebean.getTotalpagesize());
		pagebean.setTotalpagesize(pagebean.getTotalpagesize());
		
		List<Email_CGX> beanList=cgxDao.queryUserBycount((nowpage-1)*page_size,page_size);
		pagebean.setBeanList(beanList);
		return pagebean;
	}
	@Override
	public int checkTypeByType(int type,int cgx_id) {
		return cgxDao.checkTypeByType(type,cgx_id);
	}
}
