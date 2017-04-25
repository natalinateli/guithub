package com.guithub.controller;

import com.guithub.entity.User;
import com.guithub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Simple tet controller
@Controller
public class IndexController {

  @Autowired
  UserService userService;

  //Controller will return Index Page with list of Users from Data Base
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getIndexPage(Model model) {
    List<User> allUsers = userService.findAll();
    model.addAttribute("users", allUsers);
    return "index";
  }

  //Controller will reg new user and redirect us to "/"
  @RequestMapping(value = "/reg", method = RequestMethod.POST)
  public String regUser(@RequestParam("name") String name,
      @RequestParam("password") String password) {

    return "redirect:/";
  }

  //Controller will login user and redirect us to "/"
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String loginUser(@RequestParam("name") String name,
      @RequestParam("password") String password) {

    return "redirect:/";
  }

  //Controller will delete  user by ID from Data Base and redirect us to /
  @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
  public String deleteUser(@RequestParam("id") String idS) {
    try {
      long id = Long.parseLong(idS);
      userService.deleteUser(id);
    } catch (Exception e1) {
      System.out.println(e1);
      return "redirect:/";
    }
    return "redirect:/";
  }
}
