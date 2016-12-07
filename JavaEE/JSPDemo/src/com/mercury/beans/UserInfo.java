package com.mercury.beans;

import java.util.List;

public class UserInfo {
	private List<User> user;
	private String msg;
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
