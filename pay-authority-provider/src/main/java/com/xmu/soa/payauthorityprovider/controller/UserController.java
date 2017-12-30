package com.xmu.soa.payauthorityprovider.controller;

import com.xmu.soa.payauthorityprovider.dto.RegInfoDTO;
import com.xmu.soa.payauthorityprovider.entity.User;
import com.xmu.soa.payauthorityprovider.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by status200 on 2017/12/29.
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUserInfo(@RequestParam("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody RegInfoDTO dto) {

        return userService.createUserByDTO(dto);
    }
}
