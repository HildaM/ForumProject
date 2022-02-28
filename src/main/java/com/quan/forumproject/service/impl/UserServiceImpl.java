package com.quan.forumproject.service.impl;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.common.utils.JwtUtil;
import com.quan.forumproject.common.utils.RedisCache;
import com.quan.forumproject.dto.UserDetail;
import com.quan.forumproject.entity.User;
import com.quan.forumproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 10:22
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public CommonResult login(User user) {
        // 1. 获取AuthenticationManager的authenticate方法进行验证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        /**
         * 测试代码：验证失败，抛出异常提示
         **/
        if (Objects.isNull(authenticate))
            throw new RuntimeException("登录失败");

        // 2. 验证通过，生成jwt，并且返回给前端
        UserDetail userDetail = (UserDetail) authenticate.getPrincipal();
        String userId = userDetail.getUser().getId().toString();
        // 根据userId进行生成，可以选择其他方式
        String jwt = JwtUtil.createJWT(userId);

        // 3. 封装参数，并存到redis中
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwt);

        redisCache.setCacheObject("login:"+userId, userDetail);

        // 4. 响应给前端
        return CommonResult.success(tokenMap);
    }


    // 退出登录
    @Override
    public CommonResult logout() {
        // 1. 获取SecurityContextHolder中的用户信息（不需要删除）
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();  // 获取用户信息
        Long userId = userDetail.getUser().getId();

        // 2. 删除redis中的值
        redisCache.deleteObject("login:" + userId);

        return CommonResult.success("注销成功");
    }
}
