package com.xworkz.bank.gpay.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PaymentDTO {

    private Integer id;
    private String senderName;
    private Double amount;
}
