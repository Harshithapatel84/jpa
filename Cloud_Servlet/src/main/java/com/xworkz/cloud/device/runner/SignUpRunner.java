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

       SignupDTO dto=service.getSignupByMail("xyz@gmail.com");
        System.out.println(dto);

        SignupDTO dto1=service.getSignupByPassword("xyz34");
        System.out.println(dto1);

        List<SignupDTO> getByPasswordAndEmail = service.getSignupByPasswordAndEmail("xyz34", "xyz@gmail.com");
        System.out.println(getByPasswordAndEmail);


        List<SignupDTO> getByPasswordOrEmail = service.getSignupByPasswordOrEmail("xyz34", "xyz@gmail.com");
        System.out.println(getByPasswordOrEmail);


        List<SignupDTO> getByPasswordAndConfirmPassword = service.getSignupByPasswordAndConfirmPassword("xyz34", "xyz56");
        System.out.println(getByPasswordAndConfirmPassword);

        String updateById=service.updatePasswordById("io98",1);
        System.out.println(updateById);

        String updatePasswordConfirm=service.updatePasswordConfirmPasswordById("io98","io98",1);
        System.out.println(updatePasswordConfirm);

        String updateByEmail=service.updatePasswordByEmail("yhd@13","xyz@gmail.com");
        System.out.println(updateByEmail);

    }
}