package com.quan.forumproject;

import com.quan.forumproject.mapper.UserMapper;
import com.quan.forumproject.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ForumProjectApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("test");
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void testMapper() {
        System.out.println("Test userMapper");
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
