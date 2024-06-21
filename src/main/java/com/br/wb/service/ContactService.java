package com.br.wb.service;

import com.br.wb.dto.ContactDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final EmailService emailService;
    private final CheckFiedService checkFiedService;

    public void sendContact(ContactDTO contactDTO) {
        checkFiedService.checkFieldsContact(contactDTO);
        
        String from = "testewbassessoria@gmail.com";
        String to = "testewbassessoria@gmail.com";
        String subject = "UM USUÁRIO DA WB ENVIOU UMA MENSAGEM PARA VOCÊ";
        String message = "INFORMAÇÔES DO USUÁRIO" +
                "\nNome: " +  contactDTO.name() +
                "\nE-mail: " +  contactDTO.email() +
                "\nPhone: " + contactDTO.phone() +
                "\nMessage: " + contactDTO.message();

        emailService.sendEmail(from, to, subject, message);
    }
}
