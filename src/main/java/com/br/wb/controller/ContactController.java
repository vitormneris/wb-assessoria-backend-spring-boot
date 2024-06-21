package com.br.wb.controller;

import com.br.wb.dto.ContactDTO;
import com.br.wb.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping(value = "/contact")
    public ResponseEntity<Void> sendContactByEmail(@RequestBody ContactDTO contactDTO) {
        contactService.sendContact(contactDTO);
        return ResponseEntity.noContent().build();
    }
}
