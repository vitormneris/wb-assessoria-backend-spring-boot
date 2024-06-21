package com.br.wb.domain;

import com.br.wb.domain.inheritance.User;
import com.br.wb.enums.Values;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "administrator")
public class Administrator extends User {

    public Administrator(String id, String name, String email, String password) {
        super(id, name, email, password, Values.ADMIN);
    }
}
