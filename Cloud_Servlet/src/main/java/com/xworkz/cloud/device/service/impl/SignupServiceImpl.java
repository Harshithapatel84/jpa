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
        SignupEntity entity=dao.getByid(id);
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
    public List<SignupDTO> getSignupById(Integer id) {
        System.out.println("invoking getSignupById : signupServiceImpl");

        List<SignupEntity> signupEntities = dao.getSignupById(id);
        List<SignupDTO> signupDTOs = new ArrayList<>();
        for (SignupEntity entity : signupEntities) {
            SignupDTO dto = new SignupDTO();
            dto.setEmail(entity.getEmail());
            dto.setPassword(entity.getPassword());
            dto.setConfirmPassword(entity.getConfirmPassword());
            signupDTOs.add(dto);
        }
        return signupDTOs;
    }

    @Override
    public List<SignupDTO> getSignupByPassword(String password) {
        System.out.println("invoking getSignupByPassword : signupServiceImpl");
        List<SignupEntity> signupEntities = dao.getSignupByPassword(password);
        List<SignupDTO> signupDTOs = new ArrayList<>();
        for (SignupEntity entity : signupEntities) {
            SignupDTO dto = new SignupDTO();
            dto.setEmail(entity.getEmail());
            dto.setPassword(entity.getPassword());
            dto.setConfirmPassword(entity.getConfirmPassword());
            signupDTOs.add(dto);
        }
        return signupDTOs;
    }

    @Override
    public List<SignupDTO> getSignupByEmail(String email) {
        System.out.println("invoking getSignupByEmail : signupServiceImpl");
        List<SignupEntity> signupEntities = dao.getSignupByEmail(email);
        List<SignupDTO> signupDTOs = new ArrayList<>();
        for (SignupEntity entity : signupEntities) {
            SignupDTO dto = new SignupDTO();
            dto.setEmail(entity.getEmail());
            dto.setPassword(entity.getPassword());
            dto.setConfirmPassword(entity.getConfirmPassword());
            signupDTOs.add(dto);
        }
        return signupDTOs;
    }
    @Override
    public List<SignupDTO> getSignupByPasswordAndEmail(String password, String email) {
        System.out.println("invoking getSignupByPasswordAndEmail : signupServiceImpl");
        List<SignupEntity> signupEntities = dao.getSignupByPasswordAndEmail(password, email);
        List<SignupDTO> signupDTOs = new ArrayList<>();
        for (SignupEntity entity : signupEntities) {
            SignupDTO dto = new SignupDTO();
            dto.setEmail(entity.getEmail());
            dto.setPassword(entity.getPassword());
            dto.setConfirmPassword(entity.getConfirmPassword());
            signupDTOs.add(dto);
        }
        return signupDTOs;
    }

}


