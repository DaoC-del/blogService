package com.background.userService.service.impl;

import com.background.userService.entity.User;
import com.background.userService.mapper.UserMapper;
import com.background.userService.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveOrUpdateUser(User user) {
        log.info("Saving or updating user: {}", user);
        return userMapper.insert(user) > 0 || userMapper.updateById(user) > 0;
    }

    @Override
    public User findByUsername(String username) {
        log.info("Fetching user by username: {}", username);
        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }
}
