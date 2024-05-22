package com.br.wb.controller;

import com.br.wb.domain.Installment;
import com.br.wb.dto.InstallmentDTO;
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

    @GetMapping("/{userId}")
    public ResponseEntity<List<Installment>> findAllByUserId(@PathVariable String userId) {
        return ResponseEntity.ok().body(service.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<List<Installment>> insert(@RequestBody InstallmentDTO installmentDTO) {
        return ResponseEntity.ok().body(service.insert(installmentDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteAllByUserId(@PathVariable String userId) {
        service.deleteAllByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}
