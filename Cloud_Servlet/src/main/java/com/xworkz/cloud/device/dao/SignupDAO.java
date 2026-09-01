package com.xworkz.cloud.device.dao;

import com.xworkz.cloud.device.entity.SignupEntity;

import java.util.List;

public interface SignupDAO {

 Boolean save(SignupEntity signupEntity);

 Boolean saveAll(List<SignupEntity> list);

 SignupEntity getById(Integer id);

 List<SignupEntity> readAllSignupEntity();

 SignupEntity getSignupByPassword(String password);

 SignupEntity getSignupByEmail(String email);

 List<SignupEntity> getSignupByPasswordAndEmail(String password, String email);

 List<SignupEntity> getSignupByPasswordOrEmail(String password, String email);

 List<SignupEntity> getSignupByPasswordAndConfirmPassword(String password, String confirmPassword);




}