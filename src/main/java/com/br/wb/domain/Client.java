package com.br.wb.domain;

import java.util.Collection;
import java.util.List;

import com.br.wb.domain.inheritance.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Getter
@Setter
@JsonIgnoreProperties
@Document(collection = "client")
public class Client extends User {

    public static Client.RNMDocument rnmDocument;
    private String cpf;
    private RNMDocument rnm;
    private String country;
    private List<String> phones;

    public Client(String id, String name, String email, String password, String cpf, RNMDocument rnm, String country, List<String> phones) {
        super(id, name, email, password);
        this.cpf = cpf;
        this.rnm = rnm;
        this.country = country;
        this.phones = phones;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RNMDocument {
        private String number;
        private String classification;
        private String dateOfIssue;
    }
}
