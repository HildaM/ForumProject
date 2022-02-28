package com.quan.forumproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: Post
 * @Description: 帖子类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 9:27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("posts")
public class Post {
    @TableId
    private Integer pid;

    private String pname;
    private String pcontent;
    private Integer praise;
    private Timestamp pcreate;
    private Timestamp pmodified;
    private String postImg;

    private Integer tid;
    private Topic topic;

    private Long uid;
    private User user;

    private Integer rid;
    private List<PostReply> postReply;


}
