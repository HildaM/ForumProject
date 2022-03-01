package com.quan.forumproject.service.impl;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.dto.UserDetail;
import com.quan.forumproject.entity.PostReply;
import com.quan.forumproject.mapper.PostReplyMapper;
import com.quan.forumproject.service.PostreplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PostreplyServiceImpl
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/28 19:40
 */

@Service
public class PostreplyServiceImpl implements PostreplyService {

    @Autowired
    private PostReplyMapper postReplyMapper;

    // 获取指定pid的回复
    @Override
    public CommonResult getRepliesByPid(Integer pid) {
        // 1. 获取指定pid的所有回复
        List<PostReply> replies = postReplyMapper.getRepliesByPid(pid);

        if (replies.size() <= 0) return CommonResult.success("暂无回复");

        // 2. 封装参数
        Map<String, Object> result = new HashMap<>();
        result.put("pname", null);
        result.put("pid", replies.get(0).getPid());
        result.put("floor", replies);

        return CommonResult.success(result);
    }


    @Override
    public CommonResult addReply(PostReply reply) {
        // 1. 获取当前登录用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        Long uid = userDetail.getUser().getId();

        // 2. 添加用户信息
        reply.setUid(uid);

        // 3. 添加评论
        if (postReplyMapper.insert(reply) > 0)
            return CommonResult.success("添加评论成功");

        return CommonResult.failed("添加评论失败");
    }
}
