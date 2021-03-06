package com.quan.forumproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @ClassName: PostReply
 * @Description: 帖子回复表
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 9:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("postreplies")
public class PostReply {

    @TableId(type = IdType.AUTO)
    private Integer rid;

    private String comment;
    private Timestamp rtime;

    private Long uid;
    private String uname;

    private Integer pid;
    private String pname;
}
