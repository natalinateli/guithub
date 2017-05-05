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

import java.util.List;

@Controller
public class TestController {
    @Autowired
    UserService userService;

    @Autowired
    UserCookieService userCookieService;

    //Controller will return Index Page with list of Users from Data Base
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestPage(@CookieValue(name = "param", required = false) String cookie,
                              Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);
        //If no cookies the user in not authorized
        if (cookie == null) {
            return "test";
        }
        User user = userCookieService.findByuuId(cookie).getUser();
        String username = user.getUsername();
        model.addAttribute("username", username);
        model.addAttribute("cookie", cookie);
        return "test";
    }

}
