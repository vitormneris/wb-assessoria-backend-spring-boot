package com.br.wb.service;

import com.br.wb.domain.Installment;
import com.br.wb.dto.InstallmentDTO;
import com.br.wb.enums.PaymentStatus;
import com.br.wb.respositories.InstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository repository;

    public List<Installment> findAllByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }

    public List<Installment> insert(InstallmentDTO installmentDTO) {
        Double amount = installmentDTO.amount() / installmentDTO.number();
        LocalDateTime now = LocalDateTime.now();

        List<Installment> installmentList = new ArrayList<>();
        for (int i = 0; i < installmentDTO.number(); i++) {
            Installment installment = new Installment(
                    null,
                    installmentDTO.userId(),
                    "Parcela " + (i + 1) + ": " + installmentDTO.description(),
                    amount,
                    now.plusMonths(i),
                    now.plusMonths(i + 1),
                    PaymentStatus.PENDENTE);

            installmentList.add(installment);
        }

        return repository.saveAll(installmentList);
    }

    public void deleteAllByUserId(String userId) {
        repository.deleteAllByUserId(userId);
    }
}
