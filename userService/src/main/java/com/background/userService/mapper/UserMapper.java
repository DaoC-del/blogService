package com.background.userService.mapper;

import com.background.userService.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // MyBatis Plus将根据实体类和数据库表进行CRUD操作
}
