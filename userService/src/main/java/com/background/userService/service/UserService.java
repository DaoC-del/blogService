package com.background.userService.service;

import com.background.userService.entity.User;

public interface UserService {
    boolean registerUser(User user);
    User findByUsername(String username);
    boolean checkPassword(String rawPassword, String encodedPassword);
}
