package com.guithub.dao;

import com.guithub.entity.UserCookie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCookieRepository extends JpaRepository<UserCookie, Long> {

    UserCookie findByUserId(long userId);

    UserCookie findByuuId(String uuId);
}
