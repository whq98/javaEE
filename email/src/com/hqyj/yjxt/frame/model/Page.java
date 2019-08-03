package com.hqyj.yjxt.frame.model;

import java.util.List;

public class Page {
/***/
	private int page_size;//页面显示的个数
	private int totalpagesize;
	private int nowpage;//当前页面的页数      
	private int total_record;//数据库中数据的个数
	private List beanList;//当前页面应该先显示据
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getTotal_record() {
		return total_record;
	}
	public void setTotal_record(int total_record) {
		this.total_record = total_record;
	}
	public List getBeanList() {
		return beanList;
	}
	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}
	public int getTotalpagesize() {
		int totalpage=total_record/page_size;
		return total_record%page_size==0?totalpage:totalpage+1;
	}
	public void setTotalpagesize(int totalpagesize) {
		this.totalpagesize = totalpagesize;
	}
	
}
