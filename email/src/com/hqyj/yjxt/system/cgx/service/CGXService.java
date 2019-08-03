package com.hqyj.yjxt.system.cgx.service;

import java.util.List;

import com.hqyj.yjxt.frame.model.Page;
import com.hqyj.yjxt.system.cgx.model.Email_CGX;


public interface CGXService {

	List<Email_CGX> queryAllCGX();

	int deleteCGXByCGX_id(int cgx_id);

	Email_CGX queryCgxByCgx_id(int cgx_id);

	int updateTextByCgx_id(Email_CGX ec);

	Page pageList(int nowpage, int page_size);

	int checkTypeByType(int type,int cgx_id);
}
