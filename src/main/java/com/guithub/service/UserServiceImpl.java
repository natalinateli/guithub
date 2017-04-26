package com.guithub.service;

import com.guithub.dao.UserRepository;
import com.guithub.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }
}
