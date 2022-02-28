package com.quan.forumproject.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.quan.forumproject.pojo.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @ClassName: UserDetails
 * @Description: 自定义userdetails
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 11:10
 */

@Data
@NoArgsConstructor
public class UserDetail implements UserDetails {

    private static final long serialVersionUID = -3298913744691905558L;

    private User user;

    private List<String> permissions;  // 该用户所拥有的权限


    public UserDetail(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    // redis默认不会将SimpleGrantedAuthority序列化，所以要对它进行忽略
    // 而且，即使没有这个东西，也可以通过permissions再次生成！！！
    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null)
            authorities = permissions.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
