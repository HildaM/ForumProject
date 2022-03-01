package com.quan.forumproject.filter;

import com.quan.forumproject.common.utils.JwtUtil;
import com.quan.forumproject.common.utils.RedisCache;
import com.quan.forumproject.dto.UserDetail;
import com.quan.forumproject.mapper.UserMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @ClassName: JwtAuthenticationTokenFilter
 * @Description: jwt过滤器
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 15:33
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 获取token
        String token = request.getHeader("token");

        // 2. 如果token为空，则为第一次登录，放行
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. 解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token非法");
        }


        // 4. 从redis中获取信息
        String redisKey = "login:" + userId;
        UserDetail userDetail = redisCache.getCacheObject(redisKey);

        if (userDetail == null)
            throw new RuntimeException("用户未登录");

        // 4. 存入scrutinyContextHolder，因为后续的过滤器都是从这里获取认证信息的
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 5. 放行代码
        filterChain.doFilter(request, response);
    }
}
