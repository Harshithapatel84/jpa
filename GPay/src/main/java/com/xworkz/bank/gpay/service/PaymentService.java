package com.xworkz.bank.gpay.service;

import com.xworkz.bank.gpay.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    String saveAll(List<PaymentDTO>  paymentDTOList);
}
