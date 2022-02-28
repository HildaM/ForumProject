package com.quan.forumproject.service;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hilda_quan
 * @since 2022-02-28
 */
public interface PostService {

    // 获取所有帖子
    CommonResult getAllPosts();

    // 发布帖子
    CommonResult publishPost(Post post);
}
