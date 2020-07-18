package com.cyf.bean;

import java.sql.Date;

public class order {
	
	@Override
	public String toString() {
		return "order [id=" + id + ", userid=" + userid + ", count=" + count + ", price=" + price + ", time=" + time
				+ ", status=" + status + ", username=" + username + ", bookid=" + bookid + ", bookname=" + bookname
				+ "]";
	}
	private Integer id;//订单id
	private String userid;//用户id
	private Integer count;//数量
	private double price;//价格
	private String  time;//时间
	private String status;//状态
	private String username;//用户名
	private String bookid;//书id
	private String bookname;//书名
	
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

}
