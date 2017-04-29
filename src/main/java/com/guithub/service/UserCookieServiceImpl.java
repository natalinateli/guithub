package com.guithub.service;

import com.guithub.dao.UserCookieRepository;
import com.guithub.entity.User;
import com.guithub.entity.UserCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("UserCookieService")
public class UserCookieServiceImpl implements UserCookieService {

    @Autowired
    UserCookieRepository userCookieRepository;

    @Override
    public void setCookie(User user) {

        UserCookie userCookie = userCookieRepository.findByUserId(user.getId());
        String uuID;
        uuID = UUID.randomUUID().toString();
        if (userCookie != null) {
            userCookieRepository.delete(userCookie);
        }
        userCookie = new UserCookie();
        userCookie.setUser(user);
        userCookie.setUuId(uuID);
        userCookieRepository.saveAndFlush(userCookie);
    }

    @Override
    public UserCookie findByUserId(long userId) {
        return userCookieRepository.findByUserId(userId);
    }

    @Override
    public UserCookie findByuuId(String uuId) {
        return userCookieRepository.findByuuId(uuId);
    }
}
