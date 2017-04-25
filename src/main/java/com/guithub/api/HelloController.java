package com.guithub.api;

import com.guithub.entity.User;
import com.guithub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Test controller for REST API
@RestController
public class HelloController {

  @Autowired
  UserService userService;

  // Method will return list of users from Data Base
  @RequestMapping("/users")
  public List<User> index() {
    List<User> users = userService.findAll();
    return users;
  }

}