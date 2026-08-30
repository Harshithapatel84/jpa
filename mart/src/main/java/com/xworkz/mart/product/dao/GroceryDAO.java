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

    List<GroceryEntity> getGroceryByPrice(Double price);

    List<GroceryEntity> getGroceryByNameAndBrand(String name, String brand);

    List<GroceryEntity> getGroceryByPriceGreaterThan(Double price);

    List<GroceryEntity> getGroceryByPriceLessThan(Double price);

    List<GroceryEntity> getGroceryByBrandAndPrice(String brand, Double price);


}
