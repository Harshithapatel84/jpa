package com.xworkz.mart.product.service;

import com.xworkz.mart.product.dto.GroceryDTO;

import java.util.List;

public interface GroceryService {

    Boolean save(GroceryDTO dto);

   String saveAll(List<GroceryDTO> dtoList);

   GroceryDTO findByname(String name);

    List<GroceryDTO> readAllGroceryDto();
    List<GroceryDTO> getGroceryByNameDto(String name);
    }