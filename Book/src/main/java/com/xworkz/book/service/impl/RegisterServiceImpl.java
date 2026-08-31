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



}

