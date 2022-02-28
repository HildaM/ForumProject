package com.quan.forumproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.quan.forumproject.dto.UserDetail;
import com.quan.forumproject.mapper.UserMapper;
import com.quan.forumproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: UserDetailService
 * @Description: 核心用户认证服务
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 11:02
 */

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 双冒号（::）表示引用
        queryWrapper.eq(User::getUserName, username);

        // select * from users where username = #{username}
        User user = userMapper.selectOne(queryWrapper);
        // 可以换为其他异常提醒
        if (Objects.isNull(user))
            throw new RuntimeException("用户名或密码错误");

        // 2. 查询对应的权限
        // 测试代码：此处先将权限给写死
        List<String> permission = new ArrayList<>();
        permission.add("test");

        return new UserDetail(user, permission);
    }
}
