package com.guithub.dao;

import com.guithub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll();
    User saveAndFlush(User user);
    User findOne(long id);
}
