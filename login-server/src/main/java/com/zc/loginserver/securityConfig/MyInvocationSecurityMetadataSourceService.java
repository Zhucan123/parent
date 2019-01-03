package com.zc.loginserver.securityConfig;

import com.zc.loginserver.domain.entity.SysPermission;
import com.zc.loginserver.domain.entity.SysPermissionExample;
import com.zc.loginserver.domain.repository.SysPermissionMapper;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by zhuCan on 2018/12/25.
 * Project parent.
 * Date 2018/12/25   Time 16:01.
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Resource
    private SysPermissionMapper permissionMapper;

    private Map<String,Collection<ConfigAttribute>> map;

    //加载权限表中所有的权限
    private void loadResourceDifine(){
        map=new HashMap<>();
        Collection<ConfigAttribute> attributes=null;
        ConfigAttribute attribute=null;
        List<SysPermission> permissionList=permissionMapper.selectByExample(new SysPermissionExample());
        for (SysPermission permission:permissionList){
            attributes=new ArrayList<>();
            attribute=new SecurityConfig(permission.getName());
            attributes.add(attribute);
            map.put(permission.getUrl(),attributes);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map==null){
            loadResourceDifine();
        }
        HttpServletRequest request=((FilterInvocation)object).getHttpRequest();
        AntPathRequestMatcher matcher=null;
        String resUrl=null;
        for (Iterator<String> iterator=map.keySet().iterator();iterator.hasNext();){
            resUrl=iterator.next();
            matcher=new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)){
                return map.get(resUrl);
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
