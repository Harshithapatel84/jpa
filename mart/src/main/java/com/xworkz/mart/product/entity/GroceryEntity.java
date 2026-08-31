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

@NamedQueries({

        @NamedQuery(name = "getallgroceryentity", query = "select r from GroceryEntity r"),

        @NamedQuery(name = "getgrocerybyname", query = "select r from GroceryEntity r where r.name = :name"),

        @NamedQuery(name = "getgrocerybybrand", query = "select r from GroceryEntity r where r.brand = :brand"),

        @NamedQuery(name = "getgrocerybynameandbrand", query = "select r from GroceryEntity r where r.name = :name and r.brand = :brand"),

        @NamedQuery(name = "getgrocerybybrandorprice", query = "select r from GroceryEntity r where r.brand = :brand or r.price = :price"),

        @NamedQuery(name = "updatepricebyname", query = "update GroceryEntity r set r.price = :price where r.name = :name"),

        @NamedQuery(name = "updatebrandbyname", query = "update GroceryEntity r set r.brand = :brand where r.name = :name"),

        @NamedQuery(name = "updatepricebybrandandname", query = "update GroceryEntity r set r.price = :price where r.brand = :brand and r.name = :name"),

        @NamedQuery(name = "deletegrocerybyname", query = "delete from GroceryEntity r where r.name = :name"),

        @NamedQuery(name = "deletegrocerybybrandorprice", query = "delete from GroceryEntity r where r.brand = :brand or r.price = :price")

})

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

