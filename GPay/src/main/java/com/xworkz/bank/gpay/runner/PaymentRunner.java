package com.xworkz.bank.gpay.runner;

import com.xworkz.bank.gpay.dto.PaymentDTO;
import com.xworkz.bank.gpay.service.PaymentService;
import com.xworkz.bank.gpay.service.impl.PaymentServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class PaymentRunner {

    public static void main(String[] args) {

        PaymentService service = new PaymentServiceImpl();

        List<PaymentDTO> paymentDTOList = new ArrayList<>();

        paymentDTOList.add(new PaymentDTO(1,"Harshitha", 500.0));
        paymentDTOList.add(new PaymentDTO(2,"Rahul", 1000.0));
        paymentDTOList.add(new PaymentDTO(3,"Priya", 750.0));

        String saved = service.saveAll(paymentDTOList);

        System.out.println(saved);
    }
}