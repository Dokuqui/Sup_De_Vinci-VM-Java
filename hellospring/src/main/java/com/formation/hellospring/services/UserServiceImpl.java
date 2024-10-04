package com.formation.hellospring.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.formation.hellospring.models.UserModel;
import com.formation.hellospring.repository.IRepoUser;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IRepoUser userRepository;

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(int id) {
        Optional<UserModel> result = userRepository.findById(id);

        UserModel user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find user id - " + id);
        }

        return user;
    }

    @Override
    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}
