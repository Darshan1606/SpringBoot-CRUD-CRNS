package com.mycrud.crudapi.service;

import com.mycrud.crudapi.model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findUserById(Long userId);

    List<User> findAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
