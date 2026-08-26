package com.xworkz.cloud.device.service.impl;

import com.xworkz.cloud.device.dao.SignupDAO;
import com.xworkz.cloud.device.dao.impl.SignupDAOImpl;
import com.xworkz.cloud.device.dto.SignupDTO;
import com.xworkz.cloud.device.entity.SignupEntity;
import com.xworkz.cloud.device.service.SignupService;

public class SignupServiceImpl implements SignupService {

    SignupDAO dao=new SignupDAOImpl();
    @Override
    public String saveSignup(SignupDTO dto) {
        System.out.println("invoking saveSignup:SignupServiceImpl");
        String isSaved=null;
        if(dto!=null){
            SignupEntity entity=new SignupEntity();
            entity.setId(dto.getid());
            entity.setEmail(dto.getEmail());
            entity.setPassword(dto.getPassword());
            entity.setConfirmPassword(dto.getConfirmPassword());
        Boolean saved=dao.save(entity);
        if(saved){
        isSaved="data saved";
        }else{
            isSaved="data not saved";
        }
        }else{
            isSaved="data is empty";
        }
        return isSaved;
    }
}
