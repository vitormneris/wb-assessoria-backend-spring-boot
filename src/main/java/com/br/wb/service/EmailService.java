package com.br.wb.service;

import com.br.wb.domain.LastProcessMovement;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class EmailService extends AbstractMongoEventListener<LastProcessMovement> {
	@Autowired
	private  JavaMailSender mailSender;

	@Override
	public void onAfterSave(AfterSaveEvent<LastProcessMovement> event) {
		LastProcessMovement objetoSalvo = event.getSource();
		sendEmailByLastProcessMovement(objetoSalvo);
	}
	public void sendEmailByLastProcessMovement(LastProcessMovement lastProcessMovement) {
		var message = new SimpleMailMessage();
		message.setFrom("testewbassessoria@gmail.com");
		message.setTo("testewbassessoria@gmail.com");
		message.setSubject("Movimentação no processo");
		message.setText("Houve uma movimentação no seu processo!");
		mailSender.send(message);
	}

	public void sendEmail(String from, String to, String subject, String text) {
		var message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		mailSender.send(message);
	}
}