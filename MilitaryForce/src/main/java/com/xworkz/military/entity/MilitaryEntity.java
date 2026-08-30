 package com.xworkz.military.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "military")

@NamedQuery(name = "getallmilitaryentity", query = "select r from MilitaryEntity r")

@NamedQuery(name = "getmilitarybyname", query = "select r from MilitaryEntity r where r.name = :name")

@NamedQuery(name = "getmilitarybyrank", query = "select r from MilitaryEntity r where r.rank = :rank")

@NamedQuery(name = "getmilitarybyage", query = "select r from MilitaryEntity r where r.age = :age")

@NamedQuery(name = "getmilitarybynameandrank", query = "select r from MilitaryEntity r where r.name = :name and r.rank = :rank")

@NamedQuery(name = "getmilitarybyagegreaterthan", query = "select r from MilitaryEntity r where r.age > :age")

@NamedQuery(name = "getmilitarybyagelessthan",query = "select r from MilitaryEntity r where r.age < :age")

@NamedQuery(name = "getmilitarybyrankandage", query = "select r from MilitaryEntity r where r.rank = :rank and r.age = :age")

public class MilitaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "military_rank")
    private String rank;

    @Column(name = "age")
    private Integer age;
}
