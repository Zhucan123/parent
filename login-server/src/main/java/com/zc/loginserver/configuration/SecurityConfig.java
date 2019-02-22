package com.zc.loginserver.configuration;

import com.zc.loginserver.securityConfig.AnyUser;
import com.zc.loginserver.securityConfig.AnyUserDetailService;
import com.zc.loginserver.securityConfig.MyPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhuCan on 2018/12/25.
 * Project parent.
 * Date 2018/12/25   Time 9:35.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   /* @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;*/


    @Bean
    AnyUserDetailService customUserService() { //注册UserDetailsService 的bean
        return new AnyUserDetailService();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())
                .withUser("admin")
                .password("123")
                .roles("ADMIN");*/
        auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder()); //user Details Service验证

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/**/*.*");
        web.ignoring().antMatchers("/**/*.js", "/lang/*.json", "/**/*.css", "/**/*.js", "/**/*.map", "/**/*.html",
                "/**/*.png");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.anyRequest().authenticated() //任何请求,登录后可以访问
                .antMatchers("/static/**", "login.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//登录页面用户任意访问
                .permitAll()
                .successHandler(loginSuccessHandler())
                .successForwardUrl("/admin")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout()
                .permitAll(); //注销行为任意访问
        //http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.csrf().disable();
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                AnyUser userDetails = (AnyUser) authentication.getPrincipal();
                logger.debug("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }

}
