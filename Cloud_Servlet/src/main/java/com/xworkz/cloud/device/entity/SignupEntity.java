package com.xworkz.cloud.device.entity;

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
@Table(name = "signup_info")

@NamedQueries({
        @NamedQuery(name = "getAllSignupEntity", query = "select r from SignupEntity r"),
        @NamedQuery(name = "getSignupById", query = "select r from SignupEntity r where r.id = :id"),
        @NamedQuery(name = "getSignupByPassword", query = "select r from SignupEntity r where r.password = :password"),
        @NamedQuery(name = "getSignupByEmail", query = "select r from SignupEntity r where r.email = :email"),
        @NamedQuery(name = "getSignupByPasswordAndEmail", query = "select r from SignupEntity r where r.password = :password and r.email = :email"),
        @NamedQuery(name = "updatePasswordById", query = "update SignupEntity r set r.password = :password where r.id = :id"),
        @NamedQuery(name = "updateEmailById", query = "update SignupEntity r set r.email = :email where r.id = :id"),
        @NamedQuery(name = "updateConfirmPasswordById", query = "update SignupEntity r set r.confirmPassword = :confirmPassword where r.id = :id"),
        @NamedQuery(name = "deleteSignupById", query = "delete from SignupEntity r where r.id = :id"),
        @NamedQuery(name = "deleteSignupByEmail", query = "delete from SignupEntity r where r.email = :email")
})

public class SignupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

    public SignupEntity(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}