package com.br.wb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Address {
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String postalCode;
    private Integer number;
}
