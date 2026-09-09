package com.xworkz.blinkit.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="register")



public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "PhNumber")
    private  Long phNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public RegisterEntity(String name, Long phNumber, String email, String password) {
        this.name = name;
       this. phNumber = phNumber;
       this. email = email;
      this.  password = password;
    }
}
