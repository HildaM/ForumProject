package com.quan.forumproject;

import com.quan.forumproject.common.utils.JwtUtil;
import com.quan.forumproject.common.utils.RedisCache;
import com.quan.forumproject.mapper.MenuMapper;
import com.quan.forumproject.mapper.UserMapper;
import com.quan.forumproject.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static com.quan.forumproject.common.utils.JwtUtil.createJWT;

@SpringBootTest
class ForumProjectApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("test");
    }

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void testUserMapper() {
        System.out.println("Test userMapper");
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testMenuMapper() {
        System.out.println("testMenuMapper");
        List<String> strings = menuMapper.selectPermsByUserId(1);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testPasswordEncoding() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encode = encoder.encode("1234");
        System.out.println(encode);

        // 校验
        System.out.println(encoder.matches("1234", encode));
    }

    @Test
    public void testJWT() throws Exception {
//        JwtUtil jwtUtil = new JwtUtil();
        String jwt = JwtUtil.createJWT("2123");
        System.out.println(jwt);

        Claims claims = JwtUtil.parseJWT(jwt);
        String subject = claims.getSubject();
        System.out.println(subject);
//        System.out.println(claims);
    }

    @Test
    public void testRedisCache() {
        RedisCache redisCache = new RedisCache();
        boolean b = redisCache.deleteObject("login:" + 2);
        System.out.println(b);
    }

}
