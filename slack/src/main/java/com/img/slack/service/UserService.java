package com.img.slack.service;

import com.img.slack.entities.User;
import com.img.slack.exception.InvalidPasswordFormatException;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User addUser(User user) throws InvalidPasswordFormatException;

    void removeUser(int user_id);

    User updatePassword(int user_id,String password);
}
