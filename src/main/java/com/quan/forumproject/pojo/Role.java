package com.quan.forumproject.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Role
 * @Description: 角色表
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/28 9:07
 */

@TableName("forum_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    private Long id;

    private String name;

    private String role_key;


}
