package com.guithub.service;

import com.guithub.entity.User;
import com.guithub.entity.UserCookie;

public interface UserCookieService {

  void setCookie(User user);

  UserCookie findByUserId(long userId);

  UserCookie findByuuId(String uuId);
}
