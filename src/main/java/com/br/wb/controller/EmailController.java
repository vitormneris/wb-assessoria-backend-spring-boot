package com.br.wb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.wb.service.EmailService;
import com.br.wb.dto.EmailDTO;

@RestController
@RequestMapping("/email")
public class EmailController {
	private final EmailService emailService;
	
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping
	public void sendEmail(@RequestBody EmailDTO email) {
		emailService.sendEmail(email);
	}
}
