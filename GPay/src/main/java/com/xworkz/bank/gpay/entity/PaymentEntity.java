package com.xworkz.bank.gpay.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="payment")
public class PaymentEntity {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="id")
    private Integer id;
@Column(name = "senderName")
    private String senderName;
@Column(name = "amount")
    private Double amount;
}
