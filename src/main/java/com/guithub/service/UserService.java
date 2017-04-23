package com.guithub.service;

import com.guithub.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User saveAndFlush(User user);
    User findOne(long id);
    void deleteUser(long id);
}
