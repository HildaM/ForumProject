package com.quan.forumproject.service.impl;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.mapper.UserMapper;
import com.quan.forumproject.pojo.User;
import com.quan.forumproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 10:22
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonResult login(User user) {




        return null;
    }
}
