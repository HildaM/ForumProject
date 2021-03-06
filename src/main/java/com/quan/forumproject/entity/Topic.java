package com.quan.forumproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("topics")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 板块id
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    /**
     * 板块名称
     */
    @TableField("tname")
    private String tname;


}
