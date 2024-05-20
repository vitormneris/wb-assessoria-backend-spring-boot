package com.br.wb.service;

import com.br.wb.domain.Installment;
import com.br.wb.respositories.InstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository repository;

    public List<Installment> findAllByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }
}
