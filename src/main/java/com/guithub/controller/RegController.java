package com.guithub.controller;

import com.guithub.entity.User;
import com.guithub.service.UserCookieService;
import com.guithub.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegController {

    // life period of cookies
    private static final int COOKIE_AGE = 2693743;
    @Autowired
    UserService userService;
    @Autowired
    UserCookieService userCookieService;

    //Controller will reg new user and redirect us to "/"
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    String getRegitrationNewUser(@CookieValue(name = "param", required = false) String cookieReg,
                                 @RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password,
                                 HttpServletResponse response) {
        // If have cookies redirect to main page
        if (cookieReg != null) {
            return "redirect:/";
        }
        //Check if username is free
        int check = userService.ifUserExist(username);
        //If it is free
        if (check == 0) {
            // Create new user
            String md5Password = DigestUtils.md5Hex(password);
            User user = new User();
            user.setUsername(username);
            user.setPassword(md5Password);
            //Save user in data base
            user = userService.saveAndFlush(user);
            userCookieService.setCookie(user);
            //Set cookies for new user
            String uuID = userCookieService.findByUserId(user.getId()).getUuId();
            Cookie cookie = new Cookie("param", uuID);
            cookie.setMaxAge(COOKIE_AGE);
            response.addCookie(cookie);
            return "redirect:/";
        } else {
            //If it is not free
            return "redirect:/userexist";
        }
    }

}
