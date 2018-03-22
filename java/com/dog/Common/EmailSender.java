package com.dog.Common;

import java.util.Date;
import java.util.Properties;
import java.security.Security;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
		
public class EmailSender {

	public static void sendEmail() throws AddressException, MessagingException {
		

		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		final String username = "loviuscwork1@gmail.com";
		final String password = "tey1475369";
		
		Session session1 = Session.getDefaultInstance(props, new Authenticator(){
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }});
		
		Message msg = new MimeMessage(session1);
		//msg.setFrom(new InternetAddress(username + "@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("hawzhe.tey@udngroup.com.tw"));
		msg.setSubject("Hello");
		msg.setText("How are you");
		msg.setSentDate(new Date());
		Transport.send(msg);

		System.out.println("Message sent.");
		
		
	}
	
	public static void main(String args[]) throws AddressException, MessagingException {
		 sendEmail();
	}
	
}
