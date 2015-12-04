package com.javamail.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.collections.CollectionUtils;

import com.javamail.Builder;
import com.javamail.Config;
import com.javamail.Mail;
import com.javamail.exception.MailException;

public class DefaultBuilder implements Builder {

	private Multipart multipart;

	public Multipart getMultipart() {
		return multipart;
	}

	@Override
	public void builder(Mail mail) throws MailException {
		Config config = mail.getConfig();
		multipart = new MimeMultipart();
		MimeBodyPart minBodyPart = new MimeBodyPart();
		try {
			minBodyPart.setContent(mail.getBody(), config.getContentType());
			addFilePart(mail.getAttachment());
			multipart.addBodyPart(minBodyPart);
		} catch (MessagingException e) {
			throw new MailException(e);
			// TODO
		} catch (UnsupportedEncodingException e) {
			throw new MailException(e);
			// TODO
		}

	}

	private void addFilePart(List<File> files) throws MessagingException, UnsupportedEncodingException {
		if (CollectionUtils.isNotEmpty(files)) {
			for (File file : files) {
				MimeBodyPart minFilePart = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(file);
				minFilePart.setDataHandler(new DataHandler(fds));
				minFilePart.setFileName(MimeUtility.encodeText(fds.getName()));
				multipart.addBodyPart(minFilePart);
			}
		}
	}

}
