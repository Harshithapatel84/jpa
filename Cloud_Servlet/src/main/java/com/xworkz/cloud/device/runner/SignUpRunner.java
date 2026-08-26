package com.xworkz.cloud.device.runner;

import com.xworkz.cloud.device.dto.SignupDTO;
import com.xworkz.cloud.device.service.SignupService;
import com.xworkz.cloud.device.service.impl.SignupServiceImpl;

public class SignUpRunner {
    public static void main(String[] args) {
        SignupDTO dto=new SignupDTO(1,"abcd@gmail.com","avc34","unf56");
        SignupService service=new SignupServiceImpl() ;
            service.saveSignup(dto);

    }
}
