package com.javamail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.javamail.impl.DefaultBuilder;

public class MailHandle {

	private Mail mail;

	public MailHandle(Mail mail) {
		this.mail = mail;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public void handle(Sender sender, Receiver receiver) throws Exception {
		List<Receiver> receivers = new ArrayList<Receiver>();
		receivers.add(receiver);
		handle(sender, receivers);
	}

	public void handle(final Sender sender, List<Receiver> receivers) throws Exception {
		Config conifg = mail.getConfig();
		DefaultBuilder builder = new DefaultBuilder();

		Properties props = System.getProperties();
		props.put("mail.smtp.host", conifg.getSmtpServer());
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender.getUserName(), sender.getPassword());
			}
		});
		session.setDebug(false);

		Message msg = new MimeMessage(session);
		Address from_address = new InternetAddress(sender.getUserName(), sender.getDisplayName());
		msg.setFrom(from_address);

		InternetAddress[] address = new InternetAddress[receivers.size()];
		for (int i = 0; i < receivers.size(); i++) {
			address[i] = new InternetAddress(receivers.get(i).getAddress());
		}
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject(mail.getSubject());

		builder.builder(mail);
		msg.setContent(builder.getMultipart());
		msg.setSentDate(new Date());
		msg.saveChanges();
		Transport trans = session.getTransport("smtp");
		trans.connect(conifg.getSmtpServer(), sender.getUserName(), sender.getPassword());
		trans.sendMessage(msg, msg.getAllRecipients());
		trans.close();
	}

}
