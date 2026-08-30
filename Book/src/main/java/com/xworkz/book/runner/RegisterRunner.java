 package com.xworkz.book.runner;

import com.xworkz.book.dto.RegisterDTO;
import com.xworkz.book.service.RegisterService;
import com.xworkz.book.service.impl.RegisterServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RegisterRunner {

    public static void main(String[] args) {

        RegisterDTO registerDTO = new RegisterDTO(4,"Java", "James Gosling");
        RegisterService service = new RegisterServiceImpl();

        //String isSaved = service.save(registerDTO);
        //System.out.println(isSaved);


        List<RegisterDTO> registerDTOS = new ArrayList<RegisterDTO>();

        registerDTOS.add(new RegisterDTO(8,"Java", "James Gosling"));
        registerDTOS.add(new RegisterDTO(7,"Python", "Guido van Rossum"));
        registerDTOS.add(new RegisterDTO(6,"C++", "Bjarne Stroustrup"));

        //String saved = service.saveAll(registerDTOS);
        //System.out.println(saved);


        RegisterDTO getById = service.getById(1);
        System.out.println(getById);


        List<RegisterDTO> readAll = service.readAllRegisterDto();
        System.out.println(readAll);


        List<RegisterDTO> getByBookName = service.getRegisterByBookName("Java");
        System.out.println(getByBookName);


        List<RegisterDTO> getByBookAuthor = service.getRegisterByBookAuthor("James Gosling");
        System.out.println(getByBookAuthor);


        List<RegisterDTO> getByBookId = service.getRegisterByBookId(1);
        System.out.println(getByBookId);


        List<RegisterDTO> getByBookNameAndAuthor = service.getRegisterByBookNameAndAuthor("Java", "James Gosling");
        System.out.println(getByBookNameAndAuthor);


        List<RegisterDTO> getByBookIdGreaterThan = service.getRegisterByBookIdGreaterThan(1);
        System.out.println(getByBookIdGreaterThan);

        List<RegisterDTO> getByBookIdLessThan = service.getRegisterByBookIdLessThan(5);
        System.out.println(getByBookIdLessThan);

        List<RegisterDTO> getByAuthorAndBookId = service.getRegisterByAuthorAndBookId("James Gosling", 1);
        System.out.println(getByAuthorAndBookId);

    }
}
