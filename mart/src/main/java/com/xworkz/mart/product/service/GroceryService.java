package com.xworkz.mart.product.service;

import com.xworkz.mart.product.dto.GroceryDTO;

import java.util.List;

public interface GroceryService {

    Boolean save(GroceryDTO dto);

   String saveAll(List<GroceryDTO> dtoList);

   GroceryDTO findByname(String name);

    List<GroceryDTO> readAllGroceryDto();
    List<GroceryDTO> getGroceryByNameDto(String name);
    List<GroceryDTO> getGroceryByBrand(String brand);
    List<GroceryDTO> getGroceryByPrice(Double price);
    List<GroceryDTO> getGroceryByNameAndBrand( String name,String brand);
    List<GroceryDTO> getGroceryByPriceGreaterThan( Double price);
    List<GroceryDTO> getGroceryByPriceLessThan( Double price);
    List<GroceryDTO> getGroceryByBrandAndPrice( String brand, Double price);
}