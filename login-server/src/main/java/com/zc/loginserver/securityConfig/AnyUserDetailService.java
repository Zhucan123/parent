package com.zc.loginserver.securityConfig;

import com.zc.loginserver.domain.entity.SysPermission;
import com.zc.loginserver.domain.entity.SysUser;
import com.zc.loginserver.domain.entity.SysUserExample;
import com.zc.loginserver.domain.repository.SysPermissionMapper;
import com.zc.loginserver.domain.repository.SysUserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuCan on 2018/12/21.
 * Project parent.
 * Date 2018/12/21   Time 9:52.
 */
@Service
public class AnyUserDetailService implements UserDetailsService {

    @Resource
    private SysUserMapper userMapper;
    @Resource
    private SysPermissionMapper permissionMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询用户,并判断是否存在
        SysUserExample userExample = new SysUserExample();
        SysUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike(s);
        List<SysUser> sysUsers = userMapper.selectByExample(userExample);

        if (sysUsers != null && sysUsers.size() > 0) {
            SysUser user = sysUsers.get(0);
            List<SysPermission> permissionList = permissionMapper.findPermissionByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysPermission permission : permissionList) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new AnyUser(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + s + " not found!");
        }
    }
}
