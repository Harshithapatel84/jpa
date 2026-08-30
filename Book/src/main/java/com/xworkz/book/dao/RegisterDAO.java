package com.xworkz.book.dao;

import com.xworkz.book.entity.RegisterEntity;

import java.util.List;

public interface RegisterDAO {

    Boolean save(RegisterEntity entity);

    Boolean saveAll(List<RegisterEntity> registerEntityList);

    RegisterEntity getRegisterEntityById(Integer bookId);
}