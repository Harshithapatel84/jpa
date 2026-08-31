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

    List<RegisterEntity> getRegisterByBookNameAndAuthor(String bookName, String bookAuthor);

    List<RegisterEntity> getRegisterByAuthorOrBookId(String bookAuthor, Integer bookId);

    boolean updateBookNameById(String bookName, Integer bookId);

    boolean updateBookAuthorById(String bookAuthor, Integer bookId);

    boolean updateBookAuthorByNameAndBookId(String bookAuthor, String bookName, Integer bookId);

    boolean deleteRegisterByBookId(Integer bookId);

    boolean deleteRegisterByAuthorOrBookName(String bookAuthor, String bookName);


}
