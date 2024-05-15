package com.br.wb.domain;

import com.br.wb.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyPayment {

    private String id;
    private String description;
    private PaymentStatus status;
    private Double tuitionFees;
}
