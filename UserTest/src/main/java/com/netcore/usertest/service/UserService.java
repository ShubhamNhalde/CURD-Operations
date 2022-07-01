package com.netcore.usertest.service;

import com.netcore.usertest.dto.UserDTO;
import com.netcore.usertest.model.User;
import com.netcore.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository repo;

    //to register user
    @Override
    public User registerUser(UserDTO dto) {
        User user = new User(dto);
        repo.save(user);
        return user;
    }

    @Override
    public List<User> retrieveUsers() {
        List<User> list = repo.findAll();
        return list;
    }

    public User updateById(UserDTO dto, Integer userId) {
        Optional<User> user = repo.findById(userId);
        if (user.isPresent()) {
            User newUser = new User(userId, dto);
            repo.save(newUser);
            return newUser;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User deleteById(Integer userId) {
        Optional<User> user = repo.findById(userId);
        if (user.isPresent()) {
            User deleteUser = new User(userId);
            repo.deleteById(userId);
            return deleteUser;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}

