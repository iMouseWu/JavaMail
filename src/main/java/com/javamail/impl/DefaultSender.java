package com.javamail.impl;

import com.javamail.Sender;

/**
 * 发送者实体
 * 
 * @author wuhao
 *
 */
public class DefaultSender implements Sender {

	private String password;

	private String userName;

	/**
	 * 发件人名称
	 */
	private String displayName;

	public DefaultSender() {
		super();
	}

	public DefaultSender(String userName, String password) {
		this.userName = userName;
		this.password = password;

	}

	public DefaultSender(String userName, String password, String displayName) {
		this(userName, password);
		this.displayName = displayName;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}
}
