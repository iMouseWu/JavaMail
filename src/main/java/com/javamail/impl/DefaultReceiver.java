package com.javamail.impl;

import com.javamail.Receiver;

/**
 * 邮件接受者实体
 * 
 * @author wuhao
 *
 */
public class DefaultReceiver implements Receiver {

	/**
	 * 接受者邮箱地址
	 */
	private String address;

	public DefaultReceiver() {
		super();
	}

	public DefaultReceiver(String address) {
		this.address = address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getAddress() {
		return address;
	}

}
