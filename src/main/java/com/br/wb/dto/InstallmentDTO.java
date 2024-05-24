package com.br.wb.dto;

import com.br.wb.enums.PaymentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record InstallmentDTO(
        String userId,
        String description,
        LocalDateTime date,
        int number,
        Double totalAmount,
        PaymentStatus paymentStatus) {
}
