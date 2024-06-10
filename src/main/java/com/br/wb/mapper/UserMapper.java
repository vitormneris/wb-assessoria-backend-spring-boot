package com.br.wb.mapper;

import org.springframework.stereotype.Component;

import com.br.wb.dto.UserDTO;
import com.br.wb.domain.User;

@Component
public class UserMapper {
    public User mapToModel(UserDTO dto) {
        User.RNMDocument RNM = null;
        if(dto.RNM() != null) {
            RNM = new User.RNMDocument(dto.RNM().getNumber(), dto.RNM().getClassification(), dto.RNM().getDateOfIssue());
        }
        return new User(
                dto.id(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.CPF(),
                RNM,
                dto.country(),
                dto.phoneNumber()
        );
    }
}
