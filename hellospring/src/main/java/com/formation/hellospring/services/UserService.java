package com.formation.hellospring.services;

import java.util.List;

import com.formation.hellospring.models.UserModel;

public interface UserService {

    List<UserModel> findAll();
    
    UserModel findById(int id);

    UserModel save(UserModel user);

    void deleteById(int id);

}
