package com.jinrui.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: User.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-6-9 ÏÂÎç2:40:19
 */

public class User implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 463996610415013378L;
private int id;
private String username;
private String password;
private Date createTime;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
}
