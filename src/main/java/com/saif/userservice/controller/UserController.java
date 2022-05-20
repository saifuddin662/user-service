package com.saif.userservice.controller;

import com.saif.userservice.entity.UserEntity;
import com.saif.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save-user")
    @ResponseBody
    public ResponseEntity<?> saveUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<?> getUserWithDepartment(@PathVariable Long userId) {
        return userService.getUserWithDepartment(userId);
    }

}
