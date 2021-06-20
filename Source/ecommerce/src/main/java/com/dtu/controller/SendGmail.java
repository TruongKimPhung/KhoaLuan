package com.dtu.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGmail {

	public static void sendText(String email, int randomNum) throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage mailMessage;

		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(getMailSession);

		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
		mailMessage.setSubject("Verify Password");
		mailMessage.setText(String.valueOf(randomNum));

		Transport transport = getMailSession.getTransport("smtp");

		transport.connect("smtp.gmail.com", "truongkimphung1811@gmail.com", "181196phien150808");
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}

}
