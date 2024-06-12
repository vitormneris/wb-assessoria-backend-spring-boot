package com.br.wb.mapper;

import com.br.wb.domain.Client;
import org.springframework.stereotype.Component;

import com.br.wb.dto.ClientDTO;

@Component
public class ClientMapper {
    public Client mapToModel(ClientDTO dto) {
        Client.RNMDocument RNM = null;
        if(dto.rnm() != null) {
            RNM = new Client.RNMDocument(dto.rnm().getNumber(), dto.rnm().getClassification(), dto.rnm().getDateOfIssue());
        }
        return new Client(
                dto.id(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.cpf(),
                RNM,
                dto.country(),
                dto.phones()
        );
    }
}
