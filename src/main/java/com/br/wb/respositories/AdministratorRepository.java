package com.br.wb.respositories;

import com.br.wb.domain.Administrator;
import com.br.wb.domain.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends MongoRepository<Administrator, String> {

    Optional<Administrator> findByEmail(String email);
}