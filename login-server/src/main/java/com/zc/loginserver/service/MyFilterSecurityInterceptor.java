package com.zc.loginserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;


/**
 * Created by zhuCan on 2018/12/25.
 * Project parent.
 * Date 2018/12/25   Time 14:34.
 */
@Service
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{

    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Autowired
    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager) {
        super.setAccessDecisionManager(myAccessDecisionManager);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        FilterInvocation filterInvocation=new FilterInvocation(request,response,chain);
        invoke(filterInvocation);
    }

    private void invoke(FilterInvocation invocation){
        InterceptorStatusToken token=super.beforeInvocation(invocation);
        try{
            invocation.getChain().doFilter(invocation.getRequest(), invocation.getResponse());

        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            super.afterInvocation(token,null);
        }
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;

    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.filterInvocationSecurityMetadataSource;
    }
}
