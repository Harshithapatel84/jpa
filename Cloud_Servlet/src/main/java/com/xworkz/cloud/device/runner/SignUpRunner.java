package com.xworkz.cloud.device.runner;

import com.xworkz.cloud.device.dto.SignupDTO;
import com.xworkz.cloud.device.service.SignupService;
import com.xworkz.cloud.device.service.impl.SignupServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class SignUpRunner {

    public static void main(String[] args) {
        SignupDTO signupDTO=new SignupDTO("abcd@123","av45","av45");
        SignupService service=new SignupServiceImpl();
        //String isSaved=service.save(signupDTO);
        //System.out.println(isSaved);

        List<SignupDTO> signupDTOS = new ArrayList<SignupDTO>();
        signupDTOS.add(new SignupDTO( "abcd@gmail.com", "avc34", "unf56"));
        signupDTOS.add(new SignupDTO( "xyz@gmail.com", "xyz34", "xyz56"));
        signupDTOS.add(new SignupDTO( "test@gmail.com", "test34", "test56"));

        //String saved=service.saveAll(signupDTOS);
        //System.out.println(saved);

        SignupDTO getByIds=service.getById(1);
        System.out.println(getByIds);

        List<SignupDTO> readAll=service.readAllSignupDto();
        System.out.println(readAll);

        List<SignupDTO> getById = service.getSignupById(2);
        System.out.println(getById);

        List<SignupDTO> getByPassword = service.getSignupByPassword("test34");
        System.out.println(getByPassword);

        List<SignupDTO> getByEmail = service.getSignupByEmail("xyz@gmail.com");
        System.out.println(getByEmail);

        List<SignupDTO> getByPasswordAndEmail = service.getSignupByPasswordAndEmail("avc34", "abcd@gmail.com");
        System.out.println(getByPasswordAndEmail);


    }
}