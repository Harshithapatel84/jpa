 package com.xworkz.bank.gpay.runner;

import com.xworkz.bank.gpay.dto.PaymentDTO;
import com.xworkz.bank.gpay.service.PaymentService;
import com.xworkz.bank.gpay.service.impl.PaymentServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class PaymentRunner {

    public static void main(String[] args) {

        PaymentDTO paymentDTO = new PaymentDTO(8,"Harshitha", 500.0);

        PaymentService service = new PaymentServiceImpl();


        //boolean isSaved = service.save(paymentDTO);
        //System.out.println(isSaved);


        List<PaymentDTO> paymentDTOList = new ArrayList<PaymentDTO>();

        paymentDTOList.add(new PaymentDTO(5,"Harshitha", 500.0));

        paymentDTOList.add(new PaymentDTO(6,"Anu", 1000.0));

        paymentDTOList.add(new PaymentDTO(7,"Kiran", 2500.0));

        paymentDTOList.add(new PaymentDTO(8,"Harsha", 1500.0));

        paymentDTOList.add(new PaymentDTO(9,"Ravi", 3000.0));


        //Boolean saved = service.saveAll(paymentDTOList);
        //System.out.println(saved);


        PaymentDTO getByIds = service.getById(1);
        System.out.println(getByIds);

        List<PaymentDTO> readAll = service.readAllPaymentDto();
        System.out.println(readAll);


        List<PaymentDTO> getById = service.getPaymentById(2);
        System.out.println(getById);



    }
}

