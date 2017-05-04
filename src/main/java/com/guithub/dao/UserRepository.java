package com.guithub.dao;

import com.guithub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//List of methods that we will use to get Data from Data Base
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User saveAndFlush(User user);

    User findOne(long id);

    @Query(value = "SELECT * FROM User u where u.username = ?1", nativeQuery = true)
    User getOne(String username);

    @Query(value = "SELECT  COUNT(*)  FROM User u WHERE u.username = ?1", nativeQuery = true)
    int ifUserExist(String username);

    @Query(value = "SELECT u.password FROM User u WHERE u.username = ?1", nativeQuery = true)
    String password(String username);
}
