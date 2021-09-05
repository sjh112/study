package com.lagou.mapper;

import com.lagou.pojo.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> findAllUser();
}
