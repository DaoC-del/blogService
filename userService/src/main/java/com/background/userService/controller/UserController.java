package com.background.userService.controller;

import com.background.userService.entity.User;
import com.background.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveOrUpdate")
    public boolean saveOrUpdateUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user);
    }

    @GetMapping("/findByUsername")
    public User findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }
}
