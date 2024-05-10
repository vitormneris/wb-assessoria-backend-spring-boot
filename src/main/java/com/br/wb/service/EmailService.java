package com.br.wb.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.br.wb.dto.EmailDTO;

@Service
public class EmailService {
	private final JavaMailSender mailSender;
	
	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendEmail(EmailDTO email) {
		var message = new SimpleMailMessage();
		
		message.setFrom("joaomoreiraneris0@gmail.com");
		message.setTo(email.to());
		message.setSubject(email.subject());
		message.setText(email.body());
		mailSender.send(message);
	}
}