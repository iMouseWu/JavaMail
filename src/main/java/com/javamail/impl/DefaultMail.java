package com.javamail.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.javamail.Config;
import com.javamail.Mail;

public class DefaultMail implements Mail {

	private String subject;

	private String body;

	private List<String> filePaths;

	private Config config;

	public DefaultMail() {
		super();
	}

	public DefaultMail(String subject, String body, String filePath) {
		this.subject = subject;
		this.body = body;
		filePaths = new ArrayList<String>();
		filePaths.add(filePath);
	}

	public DefaultMail(String subject, String body, List<String> filePaths) {
		this.subject = subject;
		this.body = body;
		this.filePaths = filePaths;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setFilePaths(List<String> filePaths) {
		this.filePaths = filePaths;
	}

	public String getSubject() {
		return subject;
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public List<File> getAttachment() {
		List<File> files = new ArrayList<File>();
		for (String filePath : filePaths) {
			File file = new File(filePath);
			files.add(file);
		}
		return files;
	}

	@Override
	public Config getConfig() {
		if (null == config) {
			return new DefaultConfig();
		}
		return config;
	}
}
