package com.xworkz.blinkit.service;

import com.xworkz.blinkit.dao.RegisterDao;
import com.xworkz.blinkit.dao.RegisterDaoImpl;
import com.xworkz.blinkit.dto.RegisterDto;
import com.xworkz.blinkit.entity.RegisterEntity;
import com.xworkz.blinkit.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegisterService{

    RegisterDao registerDao = new RegisterDaoImpl();
    @Override
    public String save(RegisterDto dto) {
        System.out.println("invoking register service");
        String isSaved = null;

        if (dto != null) {
            Set<ConstraintViolation<RegisterDto>> violations = ValidationUtil.getValidator().validate(dto);
            System.out.println("ref of ConstraintViolation: " + violations);


            RegisterEntity entity = new RegisterEntity(
                    dto.getName(),
                    dto.getPhNumber(),
                    dto.getEmail(),
                    dto.getPassword());
            boolean saved = registerDao.save(entity);

            if (saved) {
                return "Register data saved successfully";
            } else {
                return "Register data not saved";
            }

        }
        return isSaved;

    }

    @Override
    public List<RegisterDto> validateAndGetAllRegister() {
        List<RegisterEntity> entityList=registerDao.readAllRegister();
        if (entityList!=null) {
            return entityList.stream().map(entity->new RegisterDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getPhNumber(),
                    entity.getEmail(),
                    entity.getPassword()

            )).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Boolean deleteRegisterById(Integer id) {
        System.out.println("invoking deleteRegisterById:"+id);
        return registerDao.deleteRegisterById(id);

    }


}
