package com.guithub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  //Controller will login user and redirect us to "/"
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String loginUser(@RequestParam("name") String name,
      @RequestParam("password") String password) {

    return "redirect:/";
  }

}
