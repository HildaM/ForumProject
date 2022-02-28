package com.quan.forumproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName: Menu
 * @Description: 权限表
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/28 9:04
 */
@TableName(value = "forum_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {
    private static final long serialVersionUID = 5552993973425685961L;

    @TableId
    private Long id;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 路由地址
     */
    private String path;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    private String status;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 菜单图标
     */
    private String icon;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    /**
     * 是否删除（0未删除 1已删除）
     */
    private Integer delFlag;
    /**
     * 备注
     */
    private String remark;

    /**
     * <p>
     * 角色表
     * </p>
     *
     * @author Hilda_quan
     * @since 2022-02-28
     */
    @Getter
    @Setter
    @TableName("forum_role")
    public static class Role implements Serializable {

        private static final long serialVersionUID = 1L;

        @TableId(value = "id", type = IdType.AUTO)
        private Long id;

        @TableField("name")
        private String name;

        /**
         * 角色权限字符串
         */
        @TableField("role_key")
        private String roleKey;

        /**
         * 角色状态（0正常 1停用）
         */
        @TableField("status")
        private String status;

        /**
         * del_flag
         */
        @TableField("del_flag")
        private Integer delFlag;

        @TableField("create_by")
        private Long createBy;

        @TableField("create_time")
        private LocalDateTime createTime;

        @TableField("update_by")
        private Long updateBy;

        @TableField("update_time")
        private LocalDateTime updateTime;

        /**
         * 备注
         */
        @TableField("remark")
        private String remark;


    }

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
    public static class RoleMenu implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 角色ID
         */
        @TableId(value = "role_id", type = IdType.AUTO)
        private Long roleId;

        /**
         * 菜单id
         */
        @TableId("menu_id")
        private Long menuId;


    }

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
    @TableName("forum_user_role")
    public static class UserRole implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 用户id
         */
        @TableId(value = "user_id", type = IdType.AUTO)
        private Long userId;

        /**
         * 角色id
         */
        @TableId("role_id")
        private Long roleId;


    }
}
