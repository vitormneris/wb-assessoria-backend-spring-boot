package com.br.wb.service;

import com.br.wb.domain.Installment;
import com.br.wb.dto.InstallmentDTO;
import com.br.wb.enums.PaymentStatus;
import com.br.wb.respositories.InstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository repository;

    public List<Installment> findAll() {
        return repository.findAll();
    }

    public List<Installment> findAllByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }

    public List<Installment> insert(InstallmentDTO installmentDTO) {
        Double amount = installmentDTO.totalAmount() / installmentDTO.number();
        LocalDateTime date = installmentDTO.date();

        List<Installment> installmentList = new ArrayList<>();
        for (int i = 0; i < installmentDTO.number(); i++) {
            Installment installment = new Installment(
                    null,
                    installmentDTO.userId(),
                    "Parcela " + (i + 1) + ": " + installmentDTO.description(),
                    amount,
                    date.plusMonths(i),
                    date.plusMonths(i + 1),
                    PaymentStatus.PENDENTE);

            installmentList.add(installment);
        }

        return repository.saveAll(installmentList);
    }

    public List<Installment> update(String userId, InstallmentDTO installmentDTO) {
        List<Installment> installmentList = repository.findAllByUserId(userId);

        String description = installmentDTO.description();
        Double amount = installmentDTO.totalAmount() / installmentDTO.number();
        LocalDateTime date = installmentDTO.date();

        List<Installment> installmentListModified = new ArrayList<>();
        int i = 0;
        for (Installment installment : installmentList) {
            i++;
            installment.setDescription(description);
            installment.setAmount(amount);
            installment.setIssueDate(date.plusMonths(i));
            installment.setDueDate(date.plusMonths(i + 1));
            installmentListModified.add(installment);
        }

        return repository.saveAll(installmentListModified);
    }

    public Installment updateStatusPayment(String id,  PaymentStatus paymentStatus) {
        Installment installment = repository.findById(id).orElseThrow();
        installment.setPaymentStatus(paymentStatus);

        return repository.save(installment);
    }

    public void deleteAllByUserId(String userId) {
        repository.deleteAllByUserId(userId);
    }
}
