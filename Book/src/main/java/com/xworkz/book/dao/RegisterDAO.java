package com.xworkz.book.dao;

import com.xworkz.book.entity.RegisterEntity;

import java.util.List;

public interface RegisterDAO {

    Boolean save(RegisterEntity entity);

    Boolean saveAll(List<RegisterEntity> registerEntityList);

    RegisterEntity getRegisterEntityById(Integer bookId);

    List<RegisterEntity> readAllRegisterEntity();

    List<RegisterEntity> getRegisterByBookName(String bookName);

    List<RegisterEntity> getRegisterByBookAuthor(String bookAuthor);

    List<RegisterEntity> getRegisterByBookId(Integer bookId);

    List<RegisterEntity> getRegisterByBookNameAndAuthor(
            String bookName, String bookAuthor);

    List<RegisterEntity> getRegisterByBookIdGreaterThan(
            Integer bookId);

    List<RegisterEntity> getRegisterByBookIdLessThan(
            Integer bookId);

    List<RegisterEntity> getRegisterByAuthorAndBookId(
            String bookAuthor, Integer bookId);

}

