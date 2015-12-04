package com.javamail;

import com.javamail.impl.DefaultMail;
import com.javamail.impl.DefaultReceiver;
import com.javamail.impl.DefaultSender;

public class App {

	public static void main(String[] args) throws Exception {
		DefaultMail mail = new DefaultMail("test", "hello", "D:\\2222.7z");
		DefaultSender sender = new DefaultSender("", "", "11");
		DefaultReceiver receiver = new DefaultReceiver("");

		MailHandle mailHandle = new MailHandle(mail);
		mailHandle.handle(sender, receiver);
	}
}
