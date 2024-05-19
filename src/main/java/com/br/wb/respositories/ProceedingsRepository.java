package com.br.wb.respositories;

import com.br.wb.domain.proceeding.Proceeding;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProceedingsRepository extends MongoRepository<Proceeding, String> {
}
