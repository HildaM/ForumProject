package com.quan.forumproject.controller;


import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.entity.Post;
import com.quan.forumproject.mapper.PostMapper;
import com.quan.forumproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hilda_quan
 * @since 2022-02-28
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    // 获取所有的帖子
    @RequestMapping("/getAllPosts")
    public CommonResult getAllPosts() {
        return postService.getAllPosts();
    }

    // 发布帖子
    @PostMapping("/publish")
    @PreAuthorize("hasAuthority('user:post:publish')")
    public CommonResult publishPost(@RequestBody Post post) {
        return postService.publishPost(post);
    }

}
