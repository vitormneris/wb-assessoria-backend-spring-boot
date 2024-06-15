package com.br.wb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record AddressDTO(
     String state,
     String city,
     String neighborhood,
     String street,
     String postalCode,
     Integer number) {
}
