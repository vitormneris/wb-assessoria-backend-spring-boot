package com.br.wb.dto;

import java.util.List;

import com.br.wb.domain.User.RNMDocument;

public record UsuarioDTO(String id,
                         String name,
                         String email,
                         String password,
                         String CPF,
                         RNMDocument RNM,
                         String country,
                         List<String> phoneNumber) {

}
