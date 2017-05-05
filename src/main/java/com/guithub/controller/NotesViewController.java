package com.guithub.controller;

import com.guithub.entity.User;
import com.guithub.entity.UserCookie;
import com.guithub.service.UserCookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NotesViewController {
    @Autowired
    UserCookieService userCookieService;

    @RequestMapping(value = "/notesview", method = RequestMethod.GET)
    public String getNotesView(@CookieValue(name = "param", required = false) String cookie,
                               Model model) {
        if (cookie == null) {
            return "/";
        }


        UserCookie userCookie = userCookieService.findByuuId(cookie);
        User user = userCookie.getUser();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("cookie", cookie);

        return "notesview";
    }
}
