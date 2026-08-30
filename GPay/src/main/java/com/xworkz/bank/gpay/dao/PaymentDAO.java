package com.xworkz.bank.gpay.dao;

import com.xworkz.bank.gpay.entity.PaymentEntity;

import java.util.List;

public interface PaymentDAO {

    String saveAll(List<PaymentEntity>  paymentEntityList);
}
