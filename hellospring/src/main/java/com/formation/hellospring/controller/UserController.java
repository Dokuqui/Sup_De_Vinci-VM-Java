package com.formation.hellospring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.formation.hellospring.models.UserModel;
import com.formation.hellospring.services.UserService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @GetMapping("/users")
    public List<UserModel> findAll() {
        log.info("Received request to get all users");
        List<UserModel> users = userService.findAll();
        log.info("Sending response with {} users", users.size());
        return users;
    }

    @GetMapping("/users/{userId}")
    public UserModel getUserById(@PathVariable int userId) {

        log.info("Received request to get user with id {}", userId);

        UserModel user = userService.findById(userId);

        if (user == null) {
            log.error("User id not found: {}", userId);
            throw new RuntimeException("Employee id not found - " + userId);
        }

        log.info("Sending response with user: {}", user);

        return user;
    }

    @PostMapping("/users")
    public UserModel addUser(@RequestBody UserModel user) {

        log.info("Received request to add user: {}", user);

        user.setId(0);
        UserModel dbUser = userService.save(user);

        log.info("Sending response with user: {}", dbUser);

        return dbUser;
    }

    @PutMapping("/users")
    public UserModel updateUser(@RequestBody UserModel user) {

        log.info("Received request to update user: {}", user);

        UserModel dbUser = userService.save(user);

        log.info("Sending response with user: {}", dbUser);

        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        log.info("Received request to delete user with id {}", userId);

        UserModel tempUser = userService.findById(userId);

        if (tempUser == null) {
            log.error("User id not found: {}", userId);
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        log.info("Deleted user with id {}", userId);

        return "Deleted user id - " + userId;
    }

}
