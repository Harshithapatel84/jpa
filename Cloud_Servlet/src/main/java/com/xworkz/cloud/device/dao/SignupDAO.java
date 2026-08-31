package com.xworkz.cloud.device.dao;

import com.xworkz.cloud.device.entity.SignupEntity;

import java.util.List;

public interface SignupDAO {

 Boolean save(SignupEntity signupEntity);

 Boolean saveAll(List<SignupEntity> list);

 SignupEntity getById(Integer id);

 List<SignupEntity> readAllSignupEntity();

 List<SignupEntity> getSignupById(int id);

 List<SignupEntity> getSignupByPassword(String password);

 List<SignupEntity> getSignupByEmail(String email);

 List<SignupEntity> getSignupByPasswordAndEmail(String password, String email);

 boolean updatePasswordById(int id, String password);

 boolean updateEmailById(int id, String email);

 boolean updateConfirmPasswordById(int id, String confirmPassword);

 boolean deleteSignupById(int id);

 boolean deleteSignupByEmail(String email);
}