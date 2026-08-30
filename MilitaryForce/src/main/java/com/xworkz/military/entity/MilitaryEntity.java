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
    public class MilitaryEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "name")
        private String name;

        @Column(name = "rank")
        private String rank;

        @Column(name = "age")
        private Integer age;
    }

