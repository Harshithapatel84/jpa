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

@NamedQueries({

@NamedQuery(name = "getAllMilitaryEntity", query = "select r from MilitaryEntity r"),

@NamedQuery(name = "getMilitaryByName", query = "select r from MilitaryEntity r where r.name = :name"),

@NamedQuery(name = "getMilitaryByRank", query = "select r from MilitaryEntity r where r.rank = :rank"),

@NamedQuery(name = "getMilitaryByNameAndRank", query = "select r from MilitaryEntity r where r.name = :name and r.rank = :rank"),

@NamedQuery(name = "getMilitaryByRankOrAge", query = "select r from MilitaryEntity r where r.rank = :rank or r.age = :age"),

@NamedQuery(name = "updateRankByName", query = "update MilitaryEntity r set r.rank = :rank where r.name = :name"),

@NamedQuery(name = "updateAgeByName", query = "update MilitaryEntity r set r.age = :age where r.name = :name"),

@NamedQuery(name = "updateRankByNameAndAge", query = "update MilitaryEntity r set r.rank = :rank where r.name = :name and r.age = :age"),

@NamedQuery(name = "deleteMilitaryByName", query = "delete from MilitaryEntity r where r.name = :name"),

@NamedQuery(name = "deleteMilitaryByRankOrAge", query = "delete from MilitaryEntity r where r.rank = :rank or r.age = :age")
})

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