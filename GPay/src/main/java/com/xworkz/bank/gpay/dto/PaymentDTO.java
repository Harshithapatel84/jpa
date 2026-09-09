package com.xworkz.bank.gpay.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PaymentDTO {

    @NotNull(message="id cannot be null")
    private Integer id;
    @NotNull(message = "name canot be null")
    private String senderName;
    @NotNull(message = "amount cannot be null")
    @NotBlank(message = "amount id required")
    private Double amount;
}
