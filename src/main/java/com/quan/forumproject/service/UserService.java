package com.quan.forumproject.service;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.pojo.User;

/**
 * @ClassName: UserService
 * @Description: 用户Service
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 10:21
 */
public interface UserService {
    // 登录操作
    CommonResult login(User user);

    // 退出登录
    CommonResult logout();
}
