 package com.xworkz.bank.gpay.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "payment")

@NamedQueries({@NamedQuery(name = "getAllPaymentEntity", query = "SELECT p FROM PaymentEntity p"),
        @NamedQuery(name = "getPaymentById", query = "select p from PaymentEntity p where p.id = :id"),
        @NamedQuery(name = "updateSenderNameById", query = "update PaymentEntity p set p.senderName = :senderName where p.id = :id"),
        @NamedQuery(name = "updateAmountById", query = "update PaymentEntity p set p.amount = :amount where p.id = :id"),
        @NamedQuery(name = "deletePaymentById", query = "delete from PaymentEntity p where p.id = :id"),
        @NamedQuery(name = "deletePaymentBySenderName", query = "delete from PaymentEntity p where p.senderName = :senderName"),

        @NamedQuery(name = "getPaymentBySenderName", query = "select p from PaymentEntity p where p.senderName = :senderName"),
        @NamedQuery(name = "getPaymentByAmount", query = "select p from PaymentEntity p where p.amount = :amount"),
        @NamedQuery(name = "getPaymentBySenderNameAndAmount", query = "select p from PaymentEntity p where p.senderName = :senderName and p.amount = :amount"),
        @NamedQuery(name = "getPaymentBySenderNameOrAmount", query = "select p from PaymentEntity p where p.senderName = :senderName or p.amount = :amount"),
        @NamedQuery(name = "getPaymentByAmountGreaterThan", query = "select p from PaymentEntity p where p.amount > :amount")
})



public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "senderName")
    private String senderName;

    @Column(name = "amount")
    private Double amount;

    public PaymentEntity(Integer id, String senderName, Double amount) {
        this.id = id;
        this.senderName = senderName;
        this.amount = amount;
    }
}
