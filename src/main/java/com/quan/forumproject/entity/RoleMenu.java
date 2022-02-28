package com.quan.forumproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hilda_quan
 * @since 2022-02-28
 */
@Getter
@Setter
@TableName("forum_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */

    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;


}
