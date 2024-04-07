package com.background.userService.service.impl;

import com.background.userService.entity.User;
import com.background.userService.exception.AuthenticationFailureException;
import com.background.userService.exception.RegistrationFailedException;
import com.background.userService.exception.UserNotFoundException;
import com.background.userService.mapper.UserMapper;
import com.background.userService.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean registerUser(User user) {
        log.info("Registering user: {}", user.getUsername());
        // 检查用户是否已存在
        Long count = userMapper.selectCount(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (count > 0) {
            throw new RegistrationFailedException("Username already exists");
        }
        // 加密密码
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 插入用户数据
        int inserted = userMapper.insert(user);
        return inserted > 0;
    }

    @Override
    public User findByUsername(String username) {
        log.info("Fetching user by username: {}", username);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + username);
        }
        return user;
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        boolean checkResult=passwordEncoder.matches(rawPassword, encodedPassword);
        if (!checkResult) {
            throw new AuthenticationFailureException("Invalid password");
        }
        return true;
    }
}
