package com.quan.forumproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Topic
 * @Description: 帖子主题表
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 9:34
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("topics")
public class Topic {

    @TableId
    private Integer tid;

    private String tname;
}
