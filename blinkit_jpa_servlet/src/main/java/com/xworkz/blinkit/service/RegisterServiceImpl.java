package com.xworkz.blinkit.service;

import com.xworkz.blinkit.dao.RegisterDao;
import com.xworkz.blinkit.dao.RegisterDaoImpl;
import com.xworkz.blinkit.dto.RegisterDto;
import com.xworkz.blinkit.entity.RegisterEntity;

public class RegisterServiceImpl implements RegisterService{

    RegisterDao registerDao = new RegisterDaoImpl();
    @Override
    public String save(RegisterDto dto) {
        System.out.println("invoking register service");
        String isSaved=null;

       if (dto!=null) {

           RegisterEntity entity = new RegisterEntity(dto.getName(), dto.getPhNumber(), dto.getEmail(), dto.getPassword());
           boolean saved = registerDao.save(entity);

           if (saved) {
               return "Register data saved successfully";
           } else {
               return "Register data not saved";
           }

       }


        return isSaved;
    }
}
