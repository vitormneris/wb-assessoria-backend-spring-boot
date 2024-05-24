package com.br.wb.controller;

import com.br.wb.domain.Installment;
import com.br.wb.dto.InstallmentDTO;
import com.br.wb.enums.PaymentStatus;
import com.br.wb.service.InstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/installments")
public class InstallmentController {

    @Autowired
    private InstallmentService service;

    @GetMapping()
    public ResponseEntity<List<Installment>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Installment>> findAllByUserId(@PathVariable String userId) {
        return ResponseEntity.ok().body(service.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<List<Installment>> insert(@RequestBody InstallmentDTO installmentDTO) {
        return ResponseEntity.ok().body(service.insert(installmentDTO));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<List<Installment>> update(@PathVariable String userId, @RequestBody InstallmentDTO installmentDTO) {
        return ResponseEntity.ok().body(service.update(userId, installmentDTO));
    }

    @PutMapping("/paymentStatus/{id}")
    public ResponseEntity<Installment> updateStatusPayment(@PathVariable String id, @RequestBody PaymentStatus paymentStatus) {
        return ResponseEntity.ok().body(service.updateStatusPayment(id, paymentStatus));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteAllByUserId(@PathVariable String userId) {
        service.deleteAllByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}
