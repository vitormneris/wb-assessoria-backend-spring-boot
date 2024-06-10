package com.br.wb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedController {

    @GetMapping("/protected")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este é um recurso protegido!");
    }
}