package com.xworkz.book.service.impl;

import com.xworkz.book.dao.RegisterDAO;
import com.xworkz.book.dao.impl.RegisterDaoImpl;
import com.xworkz.book.dao.impl.RegisterDaoImpl;
import com.xworkz.book.dto.RegisterDTO;
import com.xworkz.book.entity.RegisterEntity;
import com.xworkz.book.service.RegisterService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegisterService {

    RegisterDAO dao = new RegisterDaoImpl();


    @Override
    public String save(RegisterDTO registerDTO) {

        System.out.println("invoking save:RegisterServiceImpl");

        String isSaved = null;

        if (registerDTO != null) {

            RegisterEntity entity = new RegisterEntity();

            entity.setBookName(registerDTO.getBookName());
            entity.setBookAuthor(registerDTO.getBookAuthor());

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
    public String saveAll(List<RegisterDTO> list) {

        System.out.println("invoking saveAll:RegisterServiceImpl");

        String isSaved = null;

        if (list != null) {

            List<RegisterEntity> registerEntities = list.stream()
                    .map(registerDTO -> new RegisterEntity(
                            null,
                            registerDTO.getBookName(),
                            registerDTO.getBookAuthor()
                    ))
                    .collect(Collectors.toList());

            Boolean status = dao.saveAll(registerEntities);

            if (status) {
                isSaved = "data saved";
            } else {
                isSaved = "data not saved";
            }
        }

        return isSaved;
    }


    @Override
    public RegisterDTO getById(Integer bookId) {

        System.out.println("invoking getById:RegisterServiceImpl");

        RegisterEntity entity =
                dao.getRegisterEntityById(bookId);

        if (entity != null) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            return dto;
        }

        return null;
    }


    @Override
    public List<RegisterDTO> readAllRegisterDto() {

        System.out.println(
                "invoking readAll:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.readAllRegisterEntity();

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }


    @Override
    public List<RegisterDTO> getRegisterByBookName(
            String bookName) {

        System.out.println(
                "invoking getRegisterByBookName:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.getRegisterByBookName(bookName);

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }


    @Override
    public List<RegisterDTO> getRegisterByBookAuthor(
            String bookAuthor) {

        System.out.println(
                "invoking getRegisterByBookAuthor:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.getRegisterByBookAuthor(bookAuthor);

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }


    @Override
    public List<RegisterDTO> getRegisterByBookId(
            Integer bookId) {

        System.out.println(
                "invoking getRegisterByBookId:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.getRegisterByBookId(bookId);

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }


    @Override
    public List<RegisterDTO> getRegisterByBookNameAndAuthor(
            String bookName, String bookAuthor) {

        System.out.println(
                "invoking getRegisterByBookNameAndAuthor:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.getRegisterByBookNameAndAuthor(
                        bookName, bookAuthor);

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }


    @Override
    public List<RegisterDTO> getRegisterByBookIdGreaterThan(
            Integer bookId) {

        System.out.println(
                "invoking getRegisterByBookIdGreaterThan:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.getRegisterByBookIdGreaterThan(bookId);

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }


    @Override
    public List<RegisterDTO> getRegisterByBookIdLessThan(
            Integer bookId) {

        System.out.println(
                "invoking getRegisterByBookIdLessThan:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.getRegisterByBookIdLessThan(bookId);

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }


    @Override
    public List<RegisterDTO> getRegisterByAuthorAndBookId(
            String bookAuthor, Integer bookId) {

        System.out.println(
                "invoking getRegisterByAuthorAndBookId:RegisterServiceImpl");

        List<RegisterEntity> registerEntities =
                dao.getRegisterByAuthorAndBookId(
                        bookAuthor, bookId);

        List<RegisterDTO> registerDTOs =
                new ArrayList<>();

        for (RegisterEntity entity : registerEntities) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            registerDTOs.add(dto);
        }

        return registerDTOs;
    }
}

