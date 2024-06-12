package com.br.wb.dto;

import java.time.LocalDateTime;

public record InstallmentDTO(
        String userId,
        String description,
        LocalDateTime date,
        Integer quantityInstallment,
        Double totalAmount) {
}
