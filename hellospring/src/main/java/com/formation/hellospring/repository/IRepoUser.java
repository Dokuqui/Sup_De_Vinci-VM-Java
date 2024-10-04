package com.formation.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.hellospring.models.UserModel;

public interface IRepoUser extends JpaRepository<UserModel, Integer> {

}
