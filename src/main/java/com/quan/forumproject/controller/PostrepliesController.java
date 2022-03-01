package com.quan.forumproject.controller;


import com.quan.forumproject.common.api.CommonResult;
import com.quan.forumproject.entity.PostReply;
import com.quan.forumproject.service.PostreplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hilda_quan
 * @since 2022-02-28
 */
@RestController
public class PostrepliesController {

    @Autowired
    private PostreplyService postreplyService;

    // 获取指定pid的所有回复
    @RequestMapping("/detail/{pid}")
    public CommonResult getAllReply(@PathVariable Integer pid) {
        if (pid == null || pid <= 0)
            return CommonResult.failed("当前不存在回复或pid有误");
        return postreplyService.getRepliesByPid(pid);
    }


    // 在指定楼层下发布评论
    @RequestMapping("/detail/comment")
    public CommonResult publishComment(@RequestBody PostReply reply) {
        return postreplyService.addReply(reply);
    }
}
