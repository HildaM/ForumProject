package com.quan.forumproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.forumproject.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author Hilda_quan
 * @since 2022-02-28
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    // 根据用户id查询对应的权限信息
    List<String> selectPermsByUserId(@Param("userId") Integer userId);
}
