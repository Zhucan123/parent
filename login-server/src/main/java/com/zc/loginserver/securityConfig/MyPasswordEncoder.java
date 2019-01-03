package com.zc.loginserver.securityConfig;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by zhuCan on 2018/12/27.
 * Project parent.
 * Date 2018/12/27   Time 10:39.
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
