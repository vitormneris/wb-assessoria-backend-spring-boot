package com.br.wb.dto;

public record InstallmentDTO(
        String userId,
        String description,
        int number,
        Double amount) {
}
