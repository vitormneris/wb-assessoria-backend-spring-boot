package com.br.wb.respositories;

import com.br.wb.domain.LastProcessMovement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LastProcessMovementRepository extends MongoRepository<LastProcessMovement, String> {
    Optional<LastProcessMovement> findFirstByOrderByMovimentoMaisRecenteDesc();
}

