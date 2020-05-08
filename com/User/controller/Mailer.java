package com.User.controller;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer 
{
	
	public static void send(String to,int id) 
	{

		
		final String user = "darshi6936@gmail.com";
		final String pass = "9924013130";
		
		//2 stpe of varification
		//less secure app ..on
		
		
		

		Properties props = new Properties();
		//smtp http
		
		
		props.put("mail.smtp.host", "smtp.gmail.com");//gmail //protocol
		props.put("mail.smtp.auth", "true");
		

		props.put("mail.smtp.user", user);
		props.put("mail.smtp.password", pass);

		
		props.put("mail.smtp.port", 587);
		//
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		
		props.put("mail.smtp.starttls.enable", "true");//stateless protocol
		props.put("mail.smtp.EnableSSL.enable", "true");
		

	
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication() {
				//password...
				return new PasswordAuthentication(user, pass);
			}
		});
		
		
		System.out.println("----------------------");
		
		try 
		{
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			  message.setSubject("Reset Password");
			  message.setText("Go through this link http://localhost:8080/Final_project/ResetPwd.jsp?id="+id+" and enter this id"+id);
			 

			
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) 
		{
			throw new RuntimeException(e);
		}

	}
}