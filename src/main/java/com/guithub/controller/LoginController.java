package com.guithub.controller;

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
public class LoginController {

    // life period of cookies
    private static final int COOKIE_AGE = 2693743;
    @Autowired
    UserService userService;
    @Autowired
    UserCookieService userCookieService;

    //Controller will login user and redirect us to "/"
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String getLogin(@CookieValue(name = "param", required = false) String cookieLogin,
                    @RequestParam(value = "username") String username,
                    @RequestParam(value = "password") String password,
                    HttpServletResponse response) {
        // If have cookies redirect to main page
        if (cookieLogin != null) {
            return "redirect:/";
        }

        // Get entered password and get password from data base
        String hashPassword = userService.password(username);
        String md5Password = DigestUtils.md5Hex(password);

        // Check if password is correct
        if (md5Password.equals(hashPassword)) {
            userCookieService.setCookie(userService.getOne(username));
            String uuID = userCookieService.findByUserId(userService.getOne(username).getId())
                .getUuId();
            //Set his cookeis from data base
            Cookie cookie = new Cookie("param", uuID);
            cookie.setMaxAge(COOKIE_AGE);
            response.addCookie(cookie);
            return "redirect:/";

        } else {
            // if password wrong send back to main page with warning
            return "redirect:/wrongpssword";
        }
    }

}
