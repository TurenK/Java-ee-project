package cn.itcast.crm.utils;

import cn.itcast.crm.pojo.Customer;

import java.util.List;

public class Page<T> {
    
	private int total;
	private int page;
	private int size;
    private List<T> rows;

	public Page(int total, Integer page, Integer rows, List<T> list) {
		this.total = total;
		this.page = page;
		this.size = rows;
		this.rows = list;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
