package com.br.wb.respositories;

import com.br.wb.dto.proceedings.HitsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HitsRepository extends MongoRepository<HitsDTO, String> {
}
