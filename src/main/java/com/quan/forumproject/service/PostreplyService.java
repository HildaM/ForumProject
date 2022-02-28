package com.quan.forumproject.service;

import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.entity.PostReply;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hilda_quan
 * @since 2022-02-28
 */
public interface PostreplyService {

    // 获取指定的回复
    CommonResult getRepliesByPid(Integer pid);

    // 发布评论
    CommonResult addReply(PostReply reply);
}
