package com.guithub.controller;

import com.guithub.entity.User;
import com.guithub.service.UserCookieService;
import com.guithub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

//Simple test controller
@Controller
public class IndexController {

  @Autowired
  UserService userService;

  @Autowired
  UserCookieService userCookieService;

  //Controller will return Index Page with list of Users from Data Base
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getIndexPage(@CookieValue(name = "param", required = false) String cookie,
      Model model) {
    List<User> allUsers = userService.findAll();
    model.addAttribute("users", allUsers);
    //If no cookies the user in not authorized
    if (cookie == null) {
      return "index";
    }
    User user = userCookieService.findByuuId(cookie).getUser();
    String username = user.getUsername();
    model.addAttribute("username", username);
    model.addAttribute("cookie", cookie);
    return "index";
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

  // Index Page with wrong login entered
  @RequestMapping(value = "/wrongpssword", method = RequestMethod.GET)
  String getWrongLoginPage(Model model) {

    List<User> allUsers = userService.findAll();
    model.addAttribute("users", allUsers);

    model.addAttribute("massage", "Неверно указон логин или пароль. Попробуйте еще раз.");
    return "index";
  }

  // Index Page if USER exist after registration
  @RequestMapping(value = "/userexist", method = RequestMethod.GET)
  String getUserExistPage(Model model) {

    List<User> allUsers = userService.findAll();
    model.addAttribute("users", allUsers);

    model.addAttribute("massage", "Пользователь с таким логином уже существует.");
    return "index";
  }

  // Exit and delete cookies
  @RequestMapping(value = "/exit", method = RequestMethod.GET)
  String getExitPage(HttpServletResponse response) {

    Cookie cookie = new Cookie("param", "null");
    cookie.setMaxAge(0);
    response.addCookie(cookie);
    return "redirect:/";
  }
}
