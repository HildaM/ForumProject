package com.quan.forumproject;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.common.utils.JwtUtil;
import com.quan.forumproject.common.utils.RedisCache;
import com.quan.forumproject.entity.Post;
import com.quan.forumproject.entity.PostReply;
import com.quan.forumproject.mapper.MenuMapper;
import com.quan.forumproject.mapper.PostMapper;
import com.quan.forumproject.mapper.PostReplyMapper;
import com.quan.forumproject.mapper.UserMapper;
import com.quan.forumproject.entity.User;
import com.quan.forumproject.service.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> strings = menuMapper.selectPermsByUserId(1L);
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


    @Autowired
    private PostMapper postMapper;
    @Test
    public void testPostMapper() {
        List<Post> allPosts = postMapper.getAllPosts();
        for (Post post : allPosts) {
            System.out.println(post);
        }
    }


    @Autowired
    private PostReplyMapper postReplyMapper;
    @Test
    public void testReplyMapper() {
        List<PostReply> repliesByPid = postReplyMapper.getRepliesByPid(1);
        for (PostReply postReply : repliesByPid) {
            System.out.println(postReply);
        }
    }


    @Autowired
    private UserServiceImpl userService;
    @Test
    public void testUserService() {
        // 1. 测试加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("1234");
        System.out.println(encoder.matches("1234", encode));

        // 2. 测试注册
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", "NewUser");
        userInfo.put("password", "1234");
        userInfo.put("email", "123@123.com");

        CommonResult commonResult = userService.userSignUp(userInfo);
        System.out.println(commonResult);
    }

}
