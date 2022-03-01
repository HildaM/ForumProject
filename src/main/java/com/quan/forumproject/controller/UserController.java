package com.quan.forumproject.controller;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.entity.User;
import com.quan.forumproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: UserController
 * @Description: 处理有关用户请求的controller
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 10:18
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody User user) {
        // 登录操作
        return userService.login(user);
    }

    @RequestMapping("/user/logout")
    public CommonResult logout() {
        return userService.logout();
    }

    @RequestMapping("/user/detail")
    @PreAuthorize("hasAuthority('user:detail')")
    public CommonResult getDetail() {
        return userService.getCurrentUserInfo();
    }

    @PostMapping("/signup")
    public CommonResult signup(@RequestBody Map<String, String> userInfo) {
        return userService.userSignUp(userInfo);
    }
}
