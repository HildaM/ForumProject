package com.quan.forumproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.forumproject.entity.PostReply;

import java.util.List;

/**
 * @ClassName: PostReplyMapper
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 9:40
 */
public interface PostReplyMapper extends BaseMapper<PostReply> {
    // 获取指定pid的所有回复
    List<PostReply> getRepliesByPid(Integer pid);

}
