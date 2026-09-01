package com.xworkz.cloud.device.service.impl;

import com.xworkz.cloud.device.dao.SignupDAO;
import com.xworkz.cloud.device.dao.impl.SignupDAOImpl;
import com.xworkz.cloud.device.dto.SignupDTO;
import com.xworkz.cloud.device.entity.SignupEntity;
import com.xworkz.cloud.device.service.SignupService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SignupServiceImpl implements SignupService {

    SignupDAO dao = new SignupDAOImpl();

    public String save(SignupDTO signupDTO) {
        System.out.println("invoking saveSignup:SignupServiceImpl");
        String isSaved = null;
        if (signupDTO != null) {
            SignupEntity entity = new SignupEntity();
                entity.setEmail(signupDTO.getEmail());
                entity.setPassword(signupDTO.getPassword());
                entity.setConfirmPassword(signupDTO.getConfirmPassword());

            Boolean saved = dao.save(entity);
            if (saved) {
                isSaved = "data saved";
            } else {
                isSaved = "data not saved";
            }
        } else {
            isSaved = "data is empty";
        }
        return isSaved;
    }

    @Override
    public String saveAll(List<SignupDTO> list) {
        System.out.println("invoking saveAll:SignupServiceImpl");
        String isSaved = null;
if (list != null) {
    List<SignupEntity> signupEntities = list.stream().
            map(signupDTO -> new SignupEntity(
                    signupDTO.getEmail(),
            signupDTO.getPassword(),
            signupDTO.getConfirmPassword())).collect(Collectors.toList());

    Boolean status = dao.saveAll(signupEntities);

    if (status) {
        isSaved = "data saved";
    } else {
        isSaved = "data not saved";
    }
}
return isSaved;
    }

    @Override
    public SignupDTO getById(Integer id) {
        System.out.println("invoking findById:SignupServiceImpl");
        SignupEntity entity=dao.getById(id);
        if(entity!=null) {
            SignupDTO dto = new SignupDTO();
            dto.setEmail(entity.getEmail());
            dto.setPassword(entity.getPassword());
            dto.setConfirmPassword(entity.getConfirmPassword());
            return dto;
        }
        return null;
    }

    @Override
    public List<SignupDTO> readAllSignupDto() {
        System.out.println("invoking readAll signUpDto:signupServiceImpl");
        List<SignupEntity> signupEntities=dao.readAllSignupEntity();
        List<SignupEntity> signupEntities1 = dao.readAllSignupEntity();
        List<SignupDTO> signupDTOs=new ArrayList<>();
        for (SignupEntity entity:signupEntities1) {
            SignupDTO dto = new SignupDTO();
            dto.setEmail(entity.getEmail());
            dto.setPassword(entity.getPassword());
            dto.setConfirmPassword(entity.getConfirmPassword());
            signupDTOs.add(dto);
        }
        return signupDTOs;
    }

    @Override
    public SignupDTO getSignupByMail(String mail) {
        System.out.println("invoking getSignupBymail");
        SignupDTO dto = null;
        SignupEntity findBymail = dao.getSignupByEmail(mail);
        if (findBymail != null) { dto = new SignupDTO( findBymail.getEmail(), findBymail.getPassword(), findBymail.getConfirmPassword() );
        } return dto;
    }

    @Override
    public SignupDTO getSignupByPassword(String password) {
        System.out.println("invoking getSignupByPassword");
        SignupDTO dto = null;
        SignupEntity findByPassword = dao.getSignupByPassword(password);
        if (findByPassword != null) { dto = new SignupDTO( findByPassword.getEmail(), findByPassword.getPassword(), findByPassword.getConfirmPassword() );
        } return dto;
    }
    @Override
    public List<SignupDTO> getSignupByPasswordAndEmail(String password, String email) {

        System.out.println("invoking getSignupByPasswordAndEmail");

        List<SignupEntity> listOfEntity =
                dao.getSignupByPasswordAndEmail(password, email);

        List<SignupDTO> dto = null;

        if (listOfEntity != null) {

            dto = listOfEntity.stream()
                    .map(entity -> new SignupDTO(
                            entity.getEmail(),
                            entity.getPassword(),
                            entity.getConfirmPassword()))
                    .collect(Collectors.toList());
        }

        return dto;
    }


    @Override
    public List<SignupDTO> getSignupByPasswordOrEmail(String password, String email) {

        System.out.println("invoking getSignupByPasswordOrEmail");

        List<SignupEntity> listOfEntity =
                dao.getSignupByPasswordOrEmail(password, email);

        List<SignupDTO> dto = null;

        if (listOfEntity != null) {

            dto = listOfEntity.stream()
                    .map(entity -> new SignupDTO(
                            entity.getEmail(),
                            entity.getPassword(),
                            entity.getConfirmPassword()))
                    .collect(Collectors.toList());
        }

        return dto;
    }


    @Override
    public List<SignupDTO> getSignupByPasswordAndConfirmPassword(String password, String confirmPassword) {

        System.out.println("invoking getSignupByPasswordAndConfirmPassword");

        List<SignupEntity> listOfEntity =
                dao.getSignupByPasswordAndConfirmPassword(
                        password, confirmPassword);

        List<SignupDTO> dto = null;

        if (listOfEntity != null) {

            dto = listOfEntity.stream()
                    .map(entity -> new SignupDTO(
                            entity.getEmail(),
                            entity.getPassword(),
                            entity.getConfirmPassword()))
                    .collect(Collectors.toList());
        }

        return dto;
    }

}









