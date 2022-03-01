package com.quan.forumproject.service.impl;

import com.quan.forumproject.entity.Menu;
import com.quan.forumproject.entity.UserRole;
import com.quan.forumproject.mapper.UserRoleMapper;
import com.quan.forumproject.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hilda_quan
 * @since 2022-02-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean setNormalUserRole(Long userId) {
        // 配置默认的权限
        if (userRoleMapper.insert(new UserRole(userId, 1L)) > 1)
            return true;

        return false;
    }
}
