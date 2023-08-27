package com.img.slack.controller;

import com.img.slack.entities.User;
import com.img.slack.exception.InvalidPasswordFormatException;
import com.img.slack.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userServiceImp.getUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) throws InvalidPasswordFormatException {
        return userServiceImp.addUser(user);
    }

    @DeleteMapping("/removeUser/{user_id}")
    public String removeUser(@PathVariable("user_id") int user_id) {
         userServiceImp.removeUser(user_id);
        return "User "+user_id+" deleted";
    }

    @PutMapping("/updatePassword/{user_id}")
    public User updatePassword(@PathVariable("user_id") int user_id,@RequestParam("password") String password) {
        return userServiceImp.updatePassword(user_id,password);
    }

}
