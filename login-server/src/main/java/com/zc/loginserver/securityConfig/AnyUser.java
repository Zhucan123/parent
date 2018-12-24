package com.zc.loginserver.securityConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by zhuCan on 2018/12/21.
 * Project parent.
 * Date 2018/12/21   Time 9:47.
 *
 * 这个是供security登录验证用的,非entity
 */
@Getter
@Setter
public class AnyUser extends User {
    private Long id;
    private String nickname;

    public AnyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
