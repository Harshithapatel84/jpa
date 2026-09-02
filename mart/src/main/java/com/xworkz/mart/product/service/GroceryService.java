package com.xworkz.mart.product.service;

import com.xworkz.mart.product.dto.GroceryDTO;

import java.util.List;

public interface GroceryService {

    Boolean save(GroceryDTO dto);

   String saveAll(List<GroceryDTO> dtoList);

   List<GroceryDTO> readAllGroceryDto();

    GroceryDTO getByBrand(String brand);

    GroceryDTO getByName(String name);

    List<GroceryDTO>  getByBrandAndName(String name,String brand);

List<GroceryDTO> getByBrandorPrice(String brand,Double peice);

     String updatepricebyname (Double price,String name);

    String updatebrandbyname(String brand, String name);

    String updatepricebybrandandname(Double price, String brand, String name);
    }