package com.javamail.exception;

public class MailException extends Exception {

	private static final long serialVersionUID = 8471512822663788236L;

	public MailException() {
		super();
	}

	public MailException(String message) {
		super(message);
	}

	public MailException(String message, Throwable cause) {
		super(message, cause);
	}

	public MailException(Throwable cause) {
		super(cause);
	}

}
