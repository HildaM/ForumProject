package com.quan.forumproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.forumproject.entity.Post;

import java.util.List;

/**
 * @ClassName: PostMapper
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 9:40
 */
public interface PostMapper extends BaseMapper<Post> {

    // 1. 获取所有帖子
    List<Post> getAllPosts();
}
