package com.netcore.usertest.service;

import com.netcore.usertest.dto.UserDTO;
import com.netcore.usertest.model.User;

import java.util.List;

public interface IUserService {

    User registerUser(UserDTO dto);

    List<User> retrieveUsers();

    User updateById(UserDTO dto, Integer userId);

    User deleteById(Integer userId);
}
