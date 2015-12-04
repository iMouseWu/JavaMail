package com.javamail;

public interface Sender {

	/**
	 * 获取密码
	 * 
	 * @return
	 */
	String getPassword();

	/**
	 * 获取用户名
	 * 
	 * @return
	 */
	String getUserName();

	/**
	 * 获取发件人名称
	 * 
	 * @return
	 */
	String getDisplayName();

}
