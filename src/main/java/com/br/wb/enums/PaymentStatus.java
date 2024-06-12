package com.br.wb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PAGO(1),
    PENDENTE(2),
    VENCIDO(3);
    PaymentStatus(Integer id){
    }
}
