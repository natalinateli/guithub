package com.guithub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegController {

  //Controller will reg new user and redirect us to "/"
  @RequestMapping(value = "/reg", method = RequestMethod.POST)
  public String regUser(@RequestParam("name") String name,
      @RequestParam("password") String password) {

    return "redirect:/";
  }

}
