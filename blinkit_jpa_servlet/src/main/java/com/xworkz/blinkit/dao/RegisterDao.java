package com.xworkz.blinkit.dao;

import com.xworkz.blinkit.entity.RegisterEntity;

import java.util.List;

public interface RegisterDao {

   public boolean save(RegisterEntity entity);

    public List<RegisterEntity> readAllRegister();

    Boolean deleteRegisterById(Integer id);
}
