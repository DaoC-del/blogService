package com.background.userService.service;

import com.background.userService.entity.User;

public interface UserService {
    boolean saveOrUpdateUser(User user);
    User findByUsername(String username);
}
