package com.br.wb.dto;

import java.util.Set;

public record WhatsappMessageDTO(Set<String> contacts, String subject) {
	
}
