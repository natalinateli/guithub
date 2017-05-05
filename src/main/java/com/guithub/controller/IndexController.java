package com.guithub.controller;

import com.guithub.service.UserCookieService;
import com.guithub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        if (cookie != null) {
            return "redirect:/notesview";
        }

        return "index";
    }


    // Index Page with wrong login entered
    @RequestMapping(value = "/wrongpssword", method = RequestMethod.GET)
    String getWrongLoginPage(Model model) {

        model.addAttribute("massage", "You have entered wrong username, email or password");
        return "index";
    }

    // Index Page if USER exist after registration
    @RequestMapping(value = "/userexist", method = RequestMethod.GET)
    String getUserExistPage(Model model) {


        model.addAttribute("massage",
            "Username is allready exist");
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
