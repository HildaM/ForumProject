package com.quan.forumproject.service.impl;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.dto.UserDetail;
import com.quan.forumproject.entity.Post;
import com.quan.forumproject.mapper.PostMapper;
import com.quan.forumproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: PostServiceImpl
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/28 16:30
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public CommonResult getAllPosts() {
        // 1. 获取所有的帖子
        List<Post> allPosts = postMapper.getAllPosts();

        // 2. 数据校验
        if (allPosts.isEmpty())
            return CommonResult.failed("暂无帖子");

        return CommonResult.success(allPosts);
    }


    @Override
    public CommonResult publishPost(Post post) {
        // 格式：{pname=d, pcontent=d, tid=1}
        // 1. 获取当前登录用户详细信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        Long userId = userDetail.getUser().getId();

        // 2. 封装post信息
        post.setUid(userId);

        // 3. 调用postMapper
        if (postMapper.insert(post) > 0)
            return CommonResult.success("发帖成功");


        return CommonResult.failed("发帖失败");
    }
}
