package com.br.wb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record AdministratorDTO(String id,
                               String name,
                               String email,
                               String password) {
}

