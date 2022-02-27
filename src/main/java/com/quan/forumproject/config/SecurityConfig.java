package com.quan.forumproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @ClassName: SecurityConfig
 * @Description: Security配置类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 9:09
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // 配置Security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf
                .csrf().disable()
                // 不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 测试情况下，允许所有访问
                .anyRequest().permitAll();


        // 允许跨域
        http.cors();
    }
}
