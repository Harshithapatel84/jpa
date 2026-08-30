package com.xworkz.book.service;

import com.xworkz.book.dto.RegisterDTO;

import java.util.List;

public interface RegisterService {

    Boolean save(RegisterDTO dto);

    String saveAll(List<RegisterDTO> dtoList);

    RegisterDTO findById(Integer bookId);
}