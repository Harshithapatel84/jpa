
        package com.xworkz.book.service;

import com.xworkz.book.dto.RegisterDTO;

import java.util.List;

public interface RegisterService {

    String save(RegisterDTO registerDTO);

    String saveAll(List<RegisterDTO> list);

    RegisterDTO getById(Integer bookId);

    List<RegisterDTO> readAllRegisterDto();

    List<RegisterDTO> getRegisterByBookName(String bookName);


}

