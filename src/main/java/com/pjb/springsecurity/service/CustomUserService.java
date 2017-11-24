package com.pjb.springsecurity.service;

import com.pjb.springsecurity.domain.SysUser;
import com.pjb.springsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserMapper userMapper;
    /*@Autowired
    PermissionDao permissionDao;*/
    // 重写loadUserByUsername 方法获得 userdetails  类型用户
    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userMapper.findByUserName(username);
        if (user != null) {
            //List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            /*List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {

                    GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);*/
            /*List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
            for(SysRole role:user.getRoles())
            {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
                System.out.println(role.getName());
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(), authorities);*/
            return user;
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
