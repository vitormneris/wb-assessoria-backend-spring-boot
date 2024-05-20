package com.br.wb.respositories;

import com.br.wb.domain.Installment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstallmentRepository extends MongoRepository<Installment, String> {
}
