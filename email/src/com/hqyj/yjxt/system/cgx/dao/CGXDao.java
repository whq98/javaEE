package com.hqyj.yjxt.system.cgx.dao;

import java.util.List;

import com.hqyj.yjxt.system.cgx.model.Email_CGX;


public interface CGXDao {
	List<Email_CGX> queryAllCGX();

	int deleteCGXByCGX_id(int cgx_id);

	Email_CGX queryCgxByCgx_id(int cgx_id);

	int updateTextByCgx_id(Email_CGX ec);

	int queryAllCount();

	List<Email_CGX> queryUserBycount(int i, int page_size);

	int checkTypeByType(int type,int cgx_id);

}
