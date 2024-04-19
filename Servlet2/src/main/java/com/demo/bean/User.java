package com.demo.bean;

public class User {

	String name;
	String mobile;
	String date;
	int no_of_seats;
	public User() {
		super();
	}
	public User(String name, String mobile, String date, int no_of_seats) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.date = date;
		this.no_of_seats = no_of_seats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", mobile=" + mobile + ", date=" + date + ", no_of_seats=" + no_of_seats + "]";
	}

}
