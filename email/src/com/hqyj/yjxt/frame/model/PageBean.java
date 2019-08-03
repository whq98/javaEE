package com.hqyj.yjxt.frame.model;

import java.util.List;

/**
 * <p>
 * 分页实体
 * </p>
 * 
 * @Copyright (C),华清远见
 * @author zlf
 * @Date:2019年7月11日
 */
public class PageBean<T> {
	/** 当前页码（page code） */
	private int pc;
	// /** 总页数（total page） */
	// private int tp;
	/** 总记录数（total record） */
	private int tr;
	/** 每页记录数（page size） */
	private int ps;
	/** 当前页的记录 */
	private List<T> beanList;

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	/**
	 * <p>
	 * 计算总页数
	 * </p>
	 * 
	 * @author zlf
	 * @Date 2019年7月11日
	 * @return
	 */
	public int getTp() {
		// 通过总记录数和每页记录数来计算总页数
		int tp = tr / ps;
		return tr % ps == 0 ? tp : tp + 1;
	}

	// public void setTp(int tp) {
	// this.tp = tp;
	// }

	public int getTr() {
		return tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

}