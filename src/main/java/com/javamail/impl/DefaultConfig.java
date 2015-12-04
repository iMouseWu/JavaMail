package com.javamail.impl;

import com.javamail.Config;

public class DefaultConfig implements Config {

	private static final String DEFAULTCONTENTTYPE = "text/html;charset=gb2312";

	private static final String DEFAULTSMTPSERVER = "smtp.163.com";

	private String contentType;

	private String smtpServer;

	public DefaultConfig() {
		this.contentType = DEFAULTCONTENTTYPE;
		this.smtpServer = DEFAULTSMTPSERVER;
	}

	public DefaultConfig(String contentType, String smtpServer) {
		this.contentType = contentType;
		this.smtpServer = smtpServer;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public String getSmtpServer() {
		return smtpServer;
	}

}
