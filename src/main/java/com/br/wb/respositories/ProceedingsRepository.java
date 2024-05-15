package com.br.wb.respositories;

import com.br.wb.domain.proceeding.Proceeding;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProceedingsRepository extends MongoRepository<Proceeding, String> {
}
