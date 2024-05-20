package com.br.wb.controller;

import com.br.wb.domain.Installment;
import com.br.wb.service.InstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
