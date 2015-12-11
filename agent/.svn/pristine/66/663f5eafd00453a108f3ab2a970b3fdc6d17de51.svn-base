package com.harmony.themis.commons.util;

import java.util.ArrayList;
import java.util.List;
/**
 * 为返回结果生成JSON格式提供的工具类
 * @author Administrator
 *
 * @param <T>
 */
public class ListRange<T> {
	/** 调用是否成功*/
	boolean success;
	String message;
	
	/**查询结果总记录数*/
	long totalSize;
	int totalPage;
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**返回结果集合*/
	List<T> list;
	/**返回对应ID*/
	String id;
    

	int  page;
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	int rows;
	public ListRange() {
		this.totalSize = 0;
		this.list = new ArrayList<T>();
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
