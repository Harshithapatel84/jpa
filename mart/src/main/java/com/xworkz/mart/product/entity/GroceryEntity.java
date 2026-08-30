 package com.xworkz.mart.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "grocery_info")

@NamedQuery(name = "getAllGroceryEntity",
        query = "select r from GroceryEntity r")

@NamedQuery(name = "getGroceryByName",
        query = "select r from GroceryEntity r where r.name = :name")

@NamedQuery(name = "getGroceryByBrand",
        query = "select r from GroceryEntity r where r.brand = :brand")

@NamedQuery(name = "getGroceryByPrice",
        query = "select r from GroceryEntity r where r.price = :price")

@NamedQuery(
        name = "getGroceryByNameAndBrand",
        query = "select r from GroceryEntity r where r.name = :name and r.brand = :brand"
)

@NamedQuery(name = "getGroceryByPriceGreaterThan",
        query = "select r from GroceryEntity r where r.price > :price")

@NamedQuery(name = "getGroceryByPriceLessThan",
        query = "select r from GroceryEntity r where r.price < :price")

@NamedQuery(name = "getGroceryByBrandAndPrice",
        query = "select r from GroceryEntity r where r.brand = :brand and r.price = :price")

public class GroceryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "brand")
    private String brand;


    public GroceryEntity(
            String name,
            Double price,
            String brand) {

        this.name = name;
        this.price = price;
        this.brand = brand;
    }
}

