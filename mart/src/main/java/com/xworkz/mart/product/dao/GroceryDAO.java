package com.xworkz.mart.product.dao;

import com.xworkz.mart.product.entity.GroceryEntity;

import java.util.List;

public interface GroceryDAO {


    Boolean save(GroceryEntity grocery);

    Boolean saveAll(List<GroceryEntity> groceryEntityList);

    GroceryEntity getGroceryEntitybyName(String name);

    List<GroceryEntity> readAllGroceryEntity();

    List<GroceryEntity> getGroceryByName(String name);

    List<GroceryEntity> getGroceryByBrand(String brand);

    List<GroceryEntity> getGroceryByNameAndBrand(String name, String brand);

    List<GroceryEntity> getGroceryByBrandOrPrice(String brand, Double price);

    boolean updatePriceByName(Double price, String name);

    boolean updateBrandByName(String brand, String name);

    boolean updatePriceByBrandAndName(Double price, String brand, String name);

    boolean deleteGroceryByName(String name);

    boolean deleteGroceryByBrandOrPrice(String brand, Double price);


}
