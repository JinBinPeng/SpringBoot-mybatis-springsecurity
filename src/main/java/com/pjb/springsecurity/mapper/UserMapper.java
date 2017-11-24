package com.pjb.springsecurity.mapper;

import com.pjb.springsecurity.domain.SysUser;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    SysUser findByUserName(@Param("username") String username);
}
