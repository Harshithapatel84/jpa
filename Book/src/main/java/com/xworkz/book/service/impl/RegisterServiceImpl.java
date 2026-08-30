package com.xworkz.book.service.impl;

import com.xworkz.book.dao.RegisterDAO;
import com.xworkz.book.dao.impl.RegisterDaoImpl;
import com.xworkz.book.dao.impl.RegisterDaoImpl;
import com.xworkz.book.dto.RegisterDTO;
import com.xworkz.book.entity.RegisterEntity;
import com.xworkz.book.service.RegisterService;

import java.util.List;
import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegisterService {

    RegisterDAO dao = new RegisterDaoImpl();

    @Override
    public Boolean save(RegisterDTO dto) {

        System.out.println("Invoking saveBook : RegisterServiceImpl");

        Boolean isSaved = false;

        if (dto != null) {

            RegisterEntity entity = new RegisterEntity();

            entity.setBookName(dto.getBookName());
            entity.setBookAuthor(dto.getBookAuthor());

            Boolean saved = dao.save(entity);

            if (saved) {
                isSaved = true;
            } else {
                isSaved = false;
            }

        } else {
            isSaved = false;
        }

        return isSaved;
    }

    @Override
    public String saveAll(List<RegisterDTO> dtoList) {

        System.out.println("Invoking saveAll : RegisterServiceImpl");

        String isSaved = null;

        if (dtoList != null) {

            List<RegisterEntity> registerEntityList = dtoList.stream()
                    .map(registerDTO -> new RegisterEntity(registerDTO.getBookId(),
                            registerDTO.getBookName(),
                            registerDTO.getBookAuthor()))
                    .collect(Collectors.toList());

            Boolean status = dao.saveAll(registerEntityList);

            if (status) {
                isSaved = "data saved";
            } else {
                isSaved = "data not saved";
            }
        }

        return isSaved;
    }

    @Override
    public RegisterDTO findById(Integer bookId) {

        System.out.println("Invoking findRegisterDTOById : RegisterServiceImpl");

        RegisterEntity entity = dao.getRegisterEntityById(bookId);

        if (entity != null) {

            RegisterDTO dto = new RegisterDTO();

            dto.setBookId(entity.getBookId());
            dto.setBookName(entity.getBookName());
            dto.setBookAuthor(entity.getBookAuthor());

            return dto;
        }

        return null;
    }
}