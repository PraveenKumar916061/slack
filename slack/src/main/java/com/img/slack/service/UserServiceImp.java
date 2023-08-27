package com.img.slack.service;

import com.img.slack.entities.User;
import com.img.slack.exception.InvalidPasswordFormatException;
import com.img.slack.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepo userRepo;

    Pattern pattern=Pattern.compile("[a-zA-Z0-9]*[@#*&][a-zA-Z0-9]*");
    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user)throws InvalidPasswordFormatException {
        User us=new User();
        us.setUser_name(user.getUser_name());
        String password=user.getPassword();
        Matcher matcher=pattern.matcher(password);
        if(matcher.matches())
            us.setPassword(user.getPassword());
        else
            throw new InvalidPasswordFormatException();
        userRepo.save(us);
        return us;
    }

    @Override
    public void removeUser(int user_id) {
        Optional<User> user=userRepo.findById(user_id);
        if(user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
        userRepo.deleteById(user_id);
    }

    @Override
    public User updatePassword(int user_id, String password) {
        Optional<User> user=userRepo.findById(user_id);
        if(user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
        User user1=user.get();
        user1.setPassword(password);
        userRepo.save(user1);
        return user1;
    }
}
